package com.tinyspace.techblog.data

import com.tinyspace.techblog.data.model.Entry
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface  EntryRepository: JpaRepository<Entry, Long> {

    @Query("SELECT e FROM Entry e ORDER BY e.publishedDate DESC")
    fun findAllByOrderByPublishedDateDesc( pageable: Pageable): List<Entry>?


}