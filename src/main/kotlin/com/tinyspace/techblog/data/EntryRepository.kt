package com.tinyspace.techblog.data

import com.tinyspace.techblog.data.model.Entry
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcRepositoriesAutoConfiguration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EntryRepository: JpaRepository<Entry, Long> {
}