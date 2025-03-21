package com.example.internshipraionteam2.data.Firebase.DataClass

data class UserData( // untuk memberitahu program bahwa kita ingin mengambil data di bawah ini dari firestore
    var fname: String, // first name
    var lname: String, // last name
    var phone: String, // phone number
    var dob: String , // date of birth
    var lor: String, // location of residance
    var email: String,
    var uid: String ,
    var biodataisfilled: Boolean? = null,
    var cvurl: String ,
    var certificateurl: String ,
    var cvfilename: String ,
    var certificatefilename: String
)
