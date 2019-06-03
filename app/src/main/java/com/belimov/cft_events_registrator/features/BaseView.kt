package com.belimov.cft_events_registrator.features

import com.arellomobile.mvp.MvpView

interface BaseView: MvpView {

    fun showToast(message:String)

    fun showLoading()

    fun hideLoading()
}