package com.belimov.cft_events_registrator.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class EventEntity (
    @PrimaryKey var id: Int,
    var cardImage: String,
    var city: String,
    var date: Date,
    var description: String,
    var eventFormat: String,
    var eventFormatEng: String,
    var format: Int,
    var iconStatus: String,
    var status: Int,
    var title: String
)