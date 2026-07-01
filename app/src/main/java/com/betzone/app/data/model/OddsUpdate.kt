package com.betzone.app.data.model

data class OddsUpdate(
    val selectionId: String,
    val newOdds: Double,
    val version: Int, // monotonically increasing; ignore updates with version &lt;= current
)