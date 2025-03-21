package com.example.internshipraionteam2.data.Firebase.DataClass

data class CafeDetails(
    var job: String = "",
    var location: String = "",
    var name: String = "",
    var salary: String = "",
    var uid: String = "",
    var applicants: MutableList<String> = mutableListOf()
)
