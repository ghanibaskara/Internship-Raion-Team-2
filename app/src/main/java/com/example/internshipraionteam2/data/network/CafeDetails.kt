package com.example.internshipraionteam2.data.network

data class CafeDetails(
    var uid: String = "",
    var email: String = "",
    var applicants: MutableList<String> = mutableListOf()
)
