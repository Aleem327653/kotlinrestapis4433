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

    override fun updateZomatoDekiveryDetails(zomato: Zomato, id: Int): Zomato {
        var data=repo.findById(id).get()
        data.deleveryFrom=zomato.deleveryFrom
        data.deleveryAddress=zomato.deleveryAddress

        return repo.save(data)
    }

    override fun deleteZomatoDelivery(id: Int) {
        repo.deleteById(id)
    }
}