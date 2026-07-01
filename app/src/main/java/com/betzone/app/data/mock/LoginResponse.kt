package com.betzone.app.data.mock

object LoginResponse {
    val succesfulResponse ="""
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1MSJ9.mock",
        "userId": "u1",
        "displayName": "Demo User"
    """.trimIndent()

    val errorResponse ="""
        "error": "invalid_credentials", 
        "message": "Username or password is incorrect"
    """.trimIndent()
}