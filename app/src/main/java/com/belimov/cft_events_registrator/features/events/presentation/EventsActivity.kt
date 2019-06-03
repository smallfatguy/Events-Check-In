package com.belimov.cft_events_registrator.features.events.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.belimov.cft_events_registrator.App
import com.belimov.cft_events_registrator.R
import com.belimov.cft_events_registrator.features.BaseActivity
import com.belimov.cft_events_registrator.features.checkin.presentation.CheckInActivity
import com.belimov.cft_events_registrator.features.events.domain.model.Event
import kotlinx.android.synthetic.main.base_activity.*

class EventsActivity : BaseActivity(), EventsView {
    override fun showToast(message: String) {
        val toast: Toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    lateinit var adapter: EventsListAdapter

    @InjectPresenter
    lateinit var presenter: EventsPresenter

    @ProvidePresenter
    fun providePresenter(): EventsPresenter = App.appComponent.eventsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)

        adapter = EventsListAdapter(this, object : EventsListAdapter.ItemClickListener {
            override fun onEventClick(eventId: Int) {
                val participantsIntent = Intent(this@EventsActivity, CheckInActivity::class.java)
                participantsIntent.putExtra("eventId", 106)
                startActivity(participantsIntent)
            }
        })
        recycler_list.adapter = adapter
        recycler_list.layoutManager = LinearLayoutManager(this)
        presenter.loadEvents()
    }


    override fun loadEvents(events: ArrayList<Event>) {
        adapter.loadEvents(events)
        hideLoading()
    }

}
