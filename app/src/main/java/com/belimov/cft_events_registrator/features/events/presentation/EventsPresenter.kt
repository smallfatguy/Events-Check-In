package com.belimov.cft_events_registrator.features.events.presentation

import com.arellomobile.mvp.InjectViewState
import com.belimov.cft_events_registrator.features.BasePresenter
import com.belimov.cft_events_registrator.features.events.domain.EventsInteractor
import com.belimov.cft_events_registrator.features.events.domain.model.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
open class EventsPresenter @Inject constructor(
    private val interactor: EventsInteractor
) : BasePresenter<EventsView>() {

    fun loadEvents() {
        viewState.showLoading()
        val disposable: Disposable = interactor.loadEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> viewState.loadEvents(result as ArrayList<Event>) },
                {
                    viewState.hideLoading()
                    viewState.showToast("Произошла ошибка: ${it.message}")
                }
            )

        usubsribeOnDestroy(disposable)
    }
}
