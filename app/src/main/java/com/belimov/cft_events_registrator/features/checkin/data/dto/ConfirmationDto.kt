package com.belimov.cft_events_registrator.features.checkin.data.dto

data class ConfirmationDto(
    val id: Int,
    val isVisited: Boolean,
    val visitedDate: String
)