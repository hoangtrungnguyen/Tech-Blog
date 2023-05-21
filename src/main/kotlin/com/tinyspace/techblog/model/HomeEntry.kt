package com.tinyspace.techblog.model

data class HomeEntry(
    override val title: String,
    override val desPic: String,
    override val publishedDate: String,
    override val type: EntryType,
    val entryContent: String,
) : BaseEntry(

){
}