package com.tinyspace.techblog.controller

import com.tinyspace.techblog.data.EntryRepository
import com.tinyspace.techblog.data.OwnerRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AboutMeController(
    val ownerRepository: OwnerRepository
) {


    @GetMapping("/about-me")
    fun aboutMe(model: Model) : String{

        val result = ownerRepository.getReferenceById(1)
        model.addAttribute("name", result.name)
        model.addAttribute("about_me", result.aboutMe)
        model.addAttribute("active", "about-me")

        return "about-me"
    }
}