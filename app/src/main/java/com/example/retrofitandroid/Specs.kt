package com.example.retrofitandroid

import java.time.Year

data class Specs(
    val color:String?,
    val capacity: String?,
    val price: Double?,
    val year: Int?
)
//aqi tambien pondrmos nullsafe a los String