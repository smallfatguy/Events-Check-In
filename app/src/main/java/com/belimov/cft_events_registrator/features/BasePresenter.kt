package com.belimov.cft_events_registrator.features

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : MvpView> : MvpPresenter<V>() {
    val disposables: CompositeDisposable = CompositeDisposable()

    fun usubsribeOnDestroy(disposable: Disposable) = disposables.add(disposable)

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}