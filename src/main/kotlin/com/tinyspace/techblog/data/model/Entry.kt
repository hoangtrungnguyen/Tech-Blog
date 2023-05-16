package com.tinyspace.techblog.data.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
data class Entry(
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    @Column(columnDefinition = "TEXT")
    val content: String,
    val createdTime: String,
    val imageUrl: String,
    val publishedDate: String,
    val type: String? = null
) {
    constructor() :this(-1L, "", "", "", "","")
}