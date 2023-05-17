package com.tinyspace.techblog.controller

import com.tinyspace.techblog.data.EntryRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AboutMeController(
    val entryRepository: EntryRepository
) {


    @GetMapping("/about-me")
    fun aboutMe(model: Model) : String{

        return "about-me"
    }
}