package com.tinyspace.techblog.model

data class HomeEntry(val title: String,
                     val desPic: String,
                     val publishedDate: String,
                     val entryContent: String,
                     val type: EntryType
)