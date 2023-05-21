package com.tinyspace.techblog.model

data class DetailEntry(
    override val title: String,
    override val desPic: String,
    override val publishedDate: String,
    val entryDetail: String,
    override val type: EntryType,
) : BaseEntry() {
}