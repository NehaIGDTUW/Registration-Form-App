package com.nehaanand.registrationformapp

import java.io.Serializable

data class Summary(
    val title: String?,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val phoneNumber: String,
    val password: String
):Serializable