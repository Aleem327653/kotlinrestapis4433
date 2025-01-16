package com.nexon.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.nexon.model.Zomato
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*
import java.nio.charset.Charset
import kotlin.random.Random

@AutoConfigureMockMvc
@SpringBootTest
class HomeControllerTest{
    @Autowired
  lateinit var mockMvc: MockMvc

  @Autowired
  lateinit var objectMapper: ObjectMapper


  val url="http://localhost:8989/zomato"

  @Test
 fun shouldreturnAllZomatoDelivery(){

  mockMvc.get(url)
   .andDo { print() }
   .andExpect {
         status { isOk() }
         content { contentType(MediaType.APPLICATION_JSON) }
   }
  }


    @Test
    fun shouldReturnSingleZomatoDelivery(){
        val id:Int=101
        mockMvc.get(url+"/${id}")
            .andDo { print() }
            .andExpect {
                      status { isOk() }
                      content { contentType(MediaType.APPLICATION_JSON) }
            }
    }


    @Test
    fun addNewZomatoDelivery(){
        val id = Random.nextInt(101, 1000)
        val zomato=Zomato(id,"Sector 63 Haldiram","Sector 63 B41 Nexon")

        val perform=mockMvc.post(url){
                            contentType= MediaType.APPLICATION_JSON
                            content=objectMapper.writeValueAsString(zomato)
        }

        perform.andDo { print() }
            .andExpect {
                      status { isCreated() }
                      content { contentType(MediaType.APPLICATION_JSON) }
                      jsonPath("$.deleveryFrom"){value("Sector 63 Haldiram")}
            }


    }

    @Test
    fun shouldChangeZomatoDeliveryInformation(){
        val id:Int=101
       var zomato= Zomato(id,"Nexon B41","HaldiRam")

        val perform=mockMvc.put(url+"/${id}"){
            contentType= MediaType.APPLICATION_JSON
            content=objectMapper.writeValueAsString(zomato)
        }

        perform.andDo { print() }
            .andExpect {
                     status { isCreated() }
                     content { contentType(MediaType.APPLICATION_JSON) }
                     jsonPath("$.id"){value(101)}
                     jsonPath("$.deleveryFrom"){value("Nexon B41")}
                     jsonPath("$.deleveryAddress"){value("HaldiRam")}
            }
    }

    @Test
    fun shouldDeleteZomatoDeliverInformation(){
        val id:Int=102

        mockMvc.delete(url+"/${id}")
            .andDo {
                    assertTrue(id==102)
                    print()
            }
            .andExpect {
                    status { isOk() }
            }
    }
 }