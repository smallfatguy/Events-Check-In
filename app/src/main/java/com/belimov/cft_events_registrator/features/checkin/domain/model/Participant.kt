package com.belimov.cft_events_registrator.features.checkin.domain.model

import java.util.*

data class Participant(
    val agreedByManager: String,
    val city: String,
    val company: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val isVisited: Boolean,
    val lastName: String,
    val phone: String,
    val registeredDate: Date
)