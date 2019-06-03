package com.belimov.cft_events_registrator.features.checkin.data.dto

data class ParticipantDto(
    val addition: String,
    val agreedByManager: String,
    val city: String,
    val company: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val isVisited: Boolean,
    val lastName: String,
    val patronymic: String,
    val phone: String,
    val position: String,
    val registeredDate: String
)