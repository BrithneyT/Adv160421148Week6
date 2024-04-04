package com.example.advweek6160421148.model

data class Car(
    val id:String?,
    val make:String?,
    val model:String?,
    val year: String?,
    val color:String?,
    val price:String?,
    val features: List<String>?,
    val specs:CarSpecifications?
)
data class CarSpecifications(
    val engine: String?,
    val transmission: String?,
    val fuelType: String?,
    val motor: String?,
    val battery: String?
)