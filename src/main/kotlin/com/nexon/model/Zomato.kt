package com.nexon.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Zomato (@Id val id:Int, val deleveryFrom:String, val deleveryAddress:String){
}