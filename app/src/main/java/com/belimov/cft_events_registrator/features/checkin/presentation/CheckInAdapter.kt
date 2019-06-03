package com.belimov.cft_events_registrator.features.checkin.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belimov.cft_events_registrator.R
import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant

class CheckInAdapter(private val listener: ItemClickListener)
    : RecyclerView.Adapter<CheckInAdapter.ParticipantViewHolder>() {

    private val participantsList: ArrayList<Participant> = ArrayList()

    fun loadParticipants(participants: ArrayList<Participant>) {
        participantsList.clear()
        participantsList.addAll(participants)
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onCheckBoxClicked(participant: Participant)
    }

    override fun getItemCount(): Int = participantsList.size

    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        holder.bind(participantsList.get(position), listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.participant_item, parent, false)
        return ParticipantViewHolder(view)
    }

    class ParticipantViewHolder(
        private val itemView: View,
        private val participantName: TextView = itemView.findViewById(R.id.participant_name),
        private val isVisited: CheckBox = itemView.findViewById(R.id.is_visited_checkbox)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(participant: Participant, listener: ItemClickListener) {
            participantName.text = "${participant.lastName} ${participant.firstName}"
            isVisited.isChecked = participant.isVisited

            isVisited.setOnClickListener { listener.onCheckBoxClicked(participant) }
        }

    }
}