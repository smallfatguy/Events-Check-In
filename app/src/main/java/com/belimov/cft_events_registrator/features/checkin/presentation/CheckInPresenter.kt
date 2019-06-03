package com.belimov.cft_events_registrator.features.checkin.presentation

import com.arellomobile.mvp.InjectViewState
import com.belimov.cft_events_registrator.features.BasePresenter
import com.belimov.cft_events_registrator.features.checkin.domain.CheckInInteractor
import com.belimov.cft_events_registrator.features.checkin.domain.model.Participant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class CheckInPresenter @Inject constructor(private val interactor: CheckInInteractor) : BasePresenter<CheckInView>() {

    fun confirmParticipant(eventId: Int, participant: Participant) {
        viewState.showLoading()

        val disposable: Disposable = interactor.confirmPaticipant(eventId, participant)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    loadParticipants(eventId)
                    viewState.hideLoading()
                    viewState.showToast("Пользователь $it подтвержден! ")
                },
                {
                    viewState.hideLoading()
                    viewState.showToast("Произошла ошибка: ${it.message}")
                }
            )

        usubsribeOnDestroy(disposable)
    }

    fun loadParticipants(eventId: Int) {
        viewState.showLoading()

        val disposable: Disposable = interactor.loadParticipants(eventId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> viewState.loadParticipants(result as ArrayList<Participant>) },
                {
                    viewState.hideLoading()
                    viewState.showToast("Произошла ошибка: ${it.message}")
                }
            )

        usubsribeOnDestroy(disposable)

    }
}