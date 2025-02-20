package com.nexon.controller

import com.nexon.model.Zomato
import com.nexon.service.ZomatoServiceImp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("zomato")
class HomeController {
    @Autowired
    lateinit var zomatoServiceImp: ZomatoServiceImp

    @PostMapping
    fun addZomatoDelivery(@RequestBody zomato: Zomato):ResponseEntity<Zomato>{
        try {
           val data= zomatoServiceImp.addZomatoDelivery(zomato)
           return ResponseEntity(data, HttpStatus.CREATED)
        }catch (ex:Exception){
            ex.printStackTrace()
            return ResponseEntity(null,HttpStatus.BAD_REQUEST)
        }

    }

    @GetMapping
    fun findAllZomatoDelivery():ResponseEntity<List<Zomato>>{
        try {
            val list=zomatoServiceImp.findAllZomatoDelivery()
            return ResponseEntity(list,HttpStatus.OK)
        }catch (ex:Exception){
            ex.printStackTrace()
            return ResponseEntity(null,HttpStatus.NO_CONTENT)
        }
    }

    @GetMapping("{id}")
    fun findSingleDelivery(@PathVariable id:Int):ResponseEntity<Zomato>{
        try {
            val data=zomatoServiceImp.findZomatoDelivery(id)
            return ResponseEntity(data,HttpStatus.OK)
        }catch (ex:Exception){
            ex.printStackTrace()
            return ResponseEntity(null,HttpStatus.NO_CONTENT)
        }
    }

    @PutMapping("{id}")
    fun updateDeliveryAddress(@PathVariable id: Int,@RequestBody zomato: Zomato):ResponseEntity<Zomato>{
        try {
            val data=zomatoServiceImp.updateZomatoDekiveryDetails(zomato,id)
            return ResponseEntity(data,HttpStatus.CREATED)
        }catch (ex:Exception){
            ex.printStackTrace()
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("{id}")
    fun deleteDeliveryInformation(@PathVariable id: Int):ResponseEntity<String>{
        try {
            zomatoServiceImp.deleteZomatoDelivery(id)
            return ResponseEntity("Delete Zomato Delivery Information Success",HttpStatus.OK)
        }catch (ex:Exception){
            ex.printStackTrace()
            return ResponseEntity("not a valid id",HttpStatus.NO_CONTENT)
        }
    }


}