package com.nexon.model

import jakarta.persistence.Entity

@Entity
data class Zomato (val id:Int,val deleveryFrom:String,val deleveryAddress:String){
}