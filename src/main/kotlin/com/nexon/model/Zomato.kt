package com.nexon.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Zomato (@Id val id:Int, var deleveryFrom:String, var deleveryAddress:String){
}