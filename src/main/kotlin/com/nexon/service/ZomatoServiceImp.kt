package com.nexon.service

import com.nexon.model.Zomato
import com.nexon.repository.ZomatoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ZomatoServiceImp:ZomatoService {
    @Autowired
   lateinit var repo: ZomatoRepository

    override fun addZomatoDelivery(zomato: Zomato): Zomato =repo.save(zomato)

    override fun findZomatoDelivery(id: Int): Zomato =repo.findById(id).get()

    override fun findAllZomatoDelivery(): List<Zomato> =repo.findAll()
}