package com.belimov.cft_events_registrator.features.events.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.belimov.cft_events_registrator.R
import com.belimov.cft_events_registrator.extensions.getDateAsString
import com.belimov.cft_events_registrator.features.events.domain.model.Event
import com.squareup.picasso.Picasso

class EventsListAdapter(
    private val context: Context,
    private val listener: ItemClickListener
    ) : RecyclerView.Adapter<EventsListAdapter.EventsViewHolder>() {
    private val eventsList: ArrayList<Event> = ArrayList()

    fun loadEvents(events: ArrayList<Event>) {
        eventsList.clear()
        eventsList.addAll(events)
        notifyDataSetChanged()
    }

    interface ItemClickListener {

        fun onEventClick(eventId: Int)
    }

    override fun getItemCount(): Int = eventsList.size

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(eventsList.get(position), context, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventsViewHolder(view)
    }

    class EventsViewHolder(
        private val itemView: View,
        private val eventCard: View = itemView.findViewById(R.id.event_item_cardview),
        private val eventTitle: TextView = itemView.findViewById(R.id.event_title),
        private val eventDescription: TextView = itemView.findViewById(R.id.event_description),
        private val eventCity: TextView = itemView.findViewById(R.id.event_cities),
        private val eventDate: TextView = itemView.findViewById(R.id.event_date),
        private val eventImage: ImageView = itemView.findViewById(R.id.event_image)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(event: Event, context: Context, listener: ItemClickListener) {
            eventTitle.text = event.title
            eventDescription.text = event.description
            eventCity.text = event.cities
            eventDate.text = event.getDateAsString()

            Picasso.with(context).load("https://team.cft.ru${event.cardImage}").into(eventImage)

            eventCard.setOnClickListener { listener.onEventClick(event.id) }
        }

    }
}
