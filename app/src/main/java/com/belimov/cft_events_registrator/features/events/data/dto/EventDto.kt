package com.belimov.cft_events_registrator.features.events.data.dto

data class EventDto(
    val cardImage: String,
    val cities: List<City>,
    val date: EventDate,
    val description: String,
    val eventFormat: String,
    val eventFormatEng: String,
    val format: Int,
    val iconStatus: String,
    val id: Int,
    val status: Int,
    val title: String
)