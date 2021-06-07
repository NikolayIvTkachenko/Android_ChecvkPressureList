package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
open class BaseViewModel  : ViewModel() {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}