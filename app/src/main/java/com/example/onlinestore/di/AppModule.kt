package com.example.onlinestore.di

import com.example.onlinestore.domain.usecase.ScrollToBottomUseCase
import com.example.onlinestore.presentation.mainpage.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            clickSearch = get(),
            clickFreeShip = get(),
            scrollToBottom = get(),
        )
    }
}