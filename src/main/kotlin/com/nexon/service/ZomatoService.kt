package com.nexon.service

import com.nexon.model.Zomato

interface ZomatoService {
    fun addZomatoDelivery(zomato: Zomato):Zomato
    fun findZomatoDelivery(id:Int):Zomato
    fun findAllZomatoDelivery():List<Zomato>
    fun updateZomatoDekiveryDetails(zomato: Zomato,id: Int):Zomato
    fun deleteZomatoDelivery(id: Int)

}