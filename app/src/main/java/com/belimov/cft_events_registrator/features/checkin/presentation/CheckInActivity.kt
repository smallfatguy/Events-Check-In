package com.belimov.cft_events_registrator.features.checkin.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.belimov.cft_events_registrator.App
import com.belimov.cft_events_registrator.R
import com.belimov.cft_events_registrator.features.BaseActivity
import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant
import kotlinx.android.synthetic.main.base_activity.*

class CheckInActivity : BaseActivity(), CheckInView {

    lateinit var adapter: CheckInAdapter
    var eventId: Int = 106

    @InjectPresenter
    lateinit var presenter: CheckInPresenter

    @ProvidePresenter
    fun providePresenter(): CheckInPresenter = App.appComponent.checkInPresenter()

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)

        adapter = CheckInAdapter(object : CheckInAdapter.ItemClickListener {
            override fun onCheckBoxClicked(participant: Participant) {
                presenter.confirmParticipant(eventId, participant)
            }

        })
        recycler_list.adapter = adapter
        recycler_list.layoutManager = LinearLayoutManager(this)

//        eventId = intent?.getIntExtra("eventId", 106) ?: 106
        presenter.loadParticipants(eventId)
    }

    override fun loadParticipants(participants: ArrayList<Participant>) {
        adapter.loadParticipants(participants)
        hideLoading()
    }

}
