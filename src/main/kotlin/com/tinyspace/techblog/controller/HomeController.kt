package com.tinyspace.techblog.controller

import com.tinyspace.techblog.data.EntryRepository
import com.tinyspace.techblog.data.LoadDatabase
import com.tinyspace.techblog.model.EntryType
import com.tinyspace.techblog.model.HomeEntry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HomeController(
    private val entryRepository: EntryRepository,
){

    @GetMapping("/")
    fun home(model: Model) : String {
        val pageable = PageRequest.of(0, 3);
        val entryModels = entryRepository.findAll(pageable)
        val entries = entryModels.content.map {
            val type = try {
                EntryType.valueOf(it.type ?: "")
            }  catch (e: Exception) {
                log.info("${e.cause}")
                EntryType.NORMAL
            }

            HomeEntry(
                it.title,
                it.imageUrl,
                it.createdTime,
                if(it.content.length > 400) it.content.slice(0..400) else it.content,
                type
            )
        }.toList()
        val totalPageRead = entryRepository.count()

        model.addAttribute("active", "home")
        model.addAttribute("entries" , entries)
        model.addAttribute("total_page_read", totalPageRead)
        return "home"
    }


    companion object {
        private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
    }
}