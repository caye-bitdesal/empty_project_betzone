package com.betzone.app.data.mock

import com.betzone.app.data.model.OddsUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class MockWebSocket (private val scope: CoroutineScope) {
    private val _updates = MutableSharedFlow<OddsUpdate>(extraBufferCapacity = 64)
    val updates: SharedFlow<OddsUpdate> = _updates
    private var version = 0
    private val lastOdds = mutableMapOf<String, Double>() // tracks current odds per selection
    fun startSimulation(eventIds: List<String>, selectionIds: List<String>) {
        scope.launch(Dispatchers.Default) {
            delay((2000L..5000L).random().milliseconds)
            val id = selectionIds.random()
            val delta = listOf(-0.05, -0.02, 0.02, 0.05, 0.10).random()
            val currentOdds = lastOdds.getOrPut(id) { listOf(1.5, 2.5, 3.0, 3.3, 4.0).random() }
            val updated = (currentOdds + delta).coerceAtLeast(1.01)
            lastOdds[id] = updated
            version++
            _updates.emit(OddsUpdate(selectionId = id, newOdds = updated, version = version))
        }
    }
}