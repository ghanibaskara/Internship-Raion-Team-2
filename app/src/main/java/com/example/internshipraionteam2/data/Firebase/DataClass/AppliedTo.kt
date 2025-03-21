package com.example.internshipraionteam2.data.Firebase.DataClass

data class AppliedTo(
    var cafeuid: MutableList<String> = mutableListOf(),
    var appliedDate: MutableList<String> = mutableListOf(),
    var appliedforPosition: MutableList<String> = mutableListOf(),
    var uid: String
)
