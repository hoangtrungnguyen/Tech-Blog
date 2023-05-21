package com.tinyspace.techblog.data

import com.tinyspace.techblog.data.model.Owner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface OwnerRepository : JpaRepository<Owner, Long> {

    fun getFirstById(id: Long)
}