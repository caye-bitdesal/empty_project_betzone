package com.betzone.app.data.mock

object BetResponse {
    val succesfulResponse ="""
        { "status": "confirmed", "receiptId": "R-123" }
    """.trimIndent()

    val errorResponse ="""
        { "status": "odds_changed", "updatedSelections": [
        { "selectionId": "s1", "newOdds": 2.25 }
        ] }
    """.trimIndent()
}