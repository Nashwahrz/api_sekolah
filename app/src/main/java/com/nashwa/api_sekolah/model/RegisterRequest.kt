package com.nashwa.api_sekolah.model

data class RegisterRequest(
    val username : String,
    val password : String,
    val fullname : String,
    val email : String
)
