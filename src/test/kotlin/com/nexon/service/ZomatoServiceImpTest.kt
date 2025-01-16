package com.nexon.service

import com.nexon.model.Zomato
import com.nexon.repository.ZomatoRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class ZomatoServiceImpTest{

  @Autowired
  lateinit var zomatoServiceImp: ZomatoServiceImp


    @Test
    fun shouldReturnAllZomatoDelivery(){
        val list=zomatoServiceImp.findAllZomatoDelivery()
        println(list)
        assertTrue(list.size>0)
        assertTrue(list.isNotEmpty())
    }

    @Test
    fun shouldReturnSingleZomatoDelivery(){
        val id:Int=101
        val delivery=zomatoServiceImp.findZomatoDelivery(id)
        println(delivery)
        assertTrue(delivery.id>0)
        assertTrue(delivery.deleveryFrom.isNotBlank())
        assertTrue(delivery.deleveryAddress.isNotBlank())
    }

  @Nested
  @DisplayName("Add Zomato Delivery")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class addZomatoDelivery{
   @Test
   fun shouldAddBank() {
       val id = Random.nextInt(101, 1000)
   val addZomato=Zomato(id,"Haldiram","Noida Sector 63")
      val zomato= zomatoServiceImp.addZomatoDelivery(addZomato);
       println(zomato)
       assertTrue(addZomato.id==zomato.id);
       assertEquals(addZomato.deleveryAddress,zomato.deleveryAddress)
       assertEquals(addZomato.deleveryFrom,zomato.deleveryFrom)

   }
  }

    @Test
    fun shouldUpdateZomatoDeliveryInformation(){

        val updateZomato=Zomato(101,"Nexon Updated","HaldiRam")
        val zomato= zomatoServiceImp.updateZomatoDekiveryDetails(updateZomato,101)

        println(zomato)

        assertTrue(zomato.id==updateZomato.id)
        assertEquals(zomato.deleveryFrom,updateZomato.deleveryFrom)
        assertEquals(zomato.deleveryAddress,updateZomato.deleveryAddress)
    }

    @Test
    fun shouldDeleteDeliveryInformation(){
        val data=zomatoServiceImp.deleteZomatoDelivery(102)
        println(data)
        assertTrue(data==Unit)
    }

 }