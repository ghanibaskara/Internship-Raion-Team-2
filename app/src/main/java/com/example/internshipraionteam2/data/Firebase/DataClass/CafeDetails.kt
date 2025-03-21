package com.example.internshipraionteam2.data.Firebase.DataClass

data class CafeDetails(
    var job: String = "",
    var location: String = "",
    var name: String = "",
    var salary: String = "",
    var uid: String = "",
    var applicants: MutableList<String> = mutableListOf(),
    var positiondescription: String = "",
    var experience: String = "",
    var cafedescription: String = "",
    var extendedlocation: String = "",
    var worktime: String = "",
    var phone: String = "",
    var rating: String = "",
    var qualifications: MutableList<String> = mutableListOf(),
    var benefit: MutableList<String> = mutableListOf(),
    var applicationduration: String = ""
)
