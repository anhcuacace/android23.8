package com.dungnd.mvvm.ui.splash

import com.dungnd.mvvm.data.local.LocalRepository
import com.dungnd.mvvm.ui.base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val localRepository: LocalRepository
) : BaseViewModel() {
}