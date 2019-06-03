package com.belimov.cft_events_registrator.features.events.domain.model

import java.util.*

data class Event(
    val cardImage: String,
    val cities: String,
    val date: Date,
    val description: String,
    val id: Int,
    val status: Int,
    val title: String

)