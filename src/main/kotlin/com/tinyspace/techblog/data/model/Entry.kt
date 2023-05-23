package com.tinyspace.techblog.data.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.util.*


@Entity
data class Entry(
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    @Column(columnDefinition = "TEXT")
    val content: String,
    @Column(name = "created_time")
    val createdTime: Date,
    val imageUrl: String,
    @Column(name = "published_date")
    val  publishedDate: Date,
    val type: String? = null
) {
    constructor() :this(-1L, "", "", Date(), "", Date())
}