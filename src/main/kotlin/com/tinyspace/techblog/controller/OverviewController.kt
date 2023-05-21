package com.tinyspace.techblog.controller

import com.tinyspace.techblog.data.EntryRepository
import com.tinyspace.techblog.data.LoadDatabase
import com.tinyspace.techblog.model.EntryType
import com.tinyspace.techblog.model.HomeEntry
import com.tinyspace.techblog.model.OverviewEntry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class OverviewController(
    val entryRepository: EntryRepository
) {
    @GetMapping("/overview")
    fun overview(model: Model): String{
        val entryModels = entryRepository.findAll()
        val entries = entryModels.map {
            OverviewEntry(
                it.title,
                it.publishedDate,
            id = it.id.toString()
            )
        }.toList()

        val totalPageRead = entryRepository.count()

        model.addAttribute("entries", entries )
        model.addAttribute("total_page_read", totalPageRead)
        model.addAttribute("active", "home")
        return "overview"
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
    }
}