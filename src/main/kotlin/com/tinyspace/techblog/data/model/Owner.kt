package com.tinyspace.techblog.data.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
data class Owner(
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    @Column(columnDefinition = "TEXT")
    val aboutMe: String
) {
    constructor() : this(-1,"","")
}