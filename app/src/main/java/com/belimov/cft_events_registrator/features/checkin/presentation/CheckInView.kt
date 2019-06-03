package com.belimov.cft_events_registrator.features.checkin.presentation

import com.belimov.cft_events_registrator.features.BaseView
import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant

interface CheckInView: BaseView {

    fun loadParticipants(participants: ArrayList<Participant>)
}