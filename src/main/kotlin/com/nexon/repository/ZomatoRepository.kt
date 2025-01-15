package com.nexon.repository

import com.nexon.model.Zomato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ZomatoRepository :JpaRepository<Zomato,Int>{
}