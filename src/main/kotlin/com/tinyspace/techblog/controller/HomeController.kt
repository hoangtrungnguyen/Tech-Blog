package com.tinyspace.techblog.controller

import com.tinyspace.techblog.data.EntryRepository
import com.tinyspace.techblog.data.LoadDatabase
import com.tinyspace.techblog.data.model.Entry
import com.tinyspace.techblog.model.DetailEntry
import com.tinyspace.techblog.model.EntryType
import com.tinyspace.techblog.model.HomeEntry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.text.SimpleDateFormat
import java.util.*


@Controller
class HomeController(
    private val entryRepository: EntryRepository,
){


    fun findFirstThreeSortedByPublishedDate(): List<Entry?>? {
        val pageable: Pageable = PageRequest.of(0, 3)
        return entryRepository.findAllByOrderByPublishedDateDesc(pageable)
    }

    @GetMapping("/")
    fun home(model: Model) : String {
        val entryModels = findFirstThreeSortedByPublishedDate()
        val entries = entryModels?.map {
            it?.let{
                val type = try {
                    EntryType.valueOf(it.type ?: "")
                }  catch (e: Exception) {
                    log.info("${e.cause}")
                    EntryType.NORMAL
                }

                HomeEntry(
                    it.title,
                    it.imageUrl,
                    it.createdTime.formatTime(),
                    entryContent = if(it.content.length > 400) it.content.slice(0..400) else it.content,
                    type = type,
                    id = it.id.toString()
                    )
            }

        }?.toList()

        val totalPageRead = entryRepository.count()

        model.addAttribute("active", "home")
        model.addAttribute("entries" , entries)
        model.addAttribute("total_page_read", totalPageRead)
        return "home"
    }

    @GetMapping("/entry/{id}")
    fun entry(model: Model, @PathVariable id: Long): String{
        val result = entryRepository.findById(id)
        val entry = result.map {
            val type = try {
                EntryType.valueOf(it.type ?: "")
            }  catch (e: Exception) {
                log.info("${e.cause}")
                EntryType.NORMAL
            }
            DetailEntry(
                id = it.id.toString(),
                title = it.title,
                        desPic = it.imageUrl,
                        publishedDate = it.publishedDate.formatTime(),
                        entryDetail = it.content,
                        type = type,
                entryContent = it.content
            )
        }.get()
        val totalPageRead = entryRepository.count()
        model.addAttribute("active", "home")
        model.addAttribute("entry", entry)
        model.addAttribute("total_page_read", totalPageRead)
        return "entry_detail"
    }


    @GetMapping
    fun notfound():String{
        return "not-found"
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
    }
}

fun Date.formatTime(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(this)
}

fun String.dateFromString(): Date =
SimpleDateFormat("yyyy-MM-dd").parse(this)