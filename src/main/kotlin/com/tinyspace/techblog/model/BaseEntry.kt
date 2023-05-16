package com.tinyspace.techblog.model

abstract class BaseEntry {
    abstract val title: String
    abstract val desPic: String
    abstract val publishedDate: String
    abstract val type: EntryType
}

enum class EntryType{
    NORMAL,
    IMAGE,
    QUOTE
}