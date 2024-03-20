package com.example.onlinestore.di

import com.example.onlinestore.domain.models.DefValue
import com.example.onlinestore.domain.usecase.ClickFreeShipUseCase
import com.example.onlinestore.domain.usecase.ClickSearchUseCase
import com.example.onlinestore.domain.usecase.ScrollToBottomUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<ClickFreeShipUseCase> {
        ClickFreeShipUseCase(defValue = get())
    }

    factory<ClickSearchUseCase> {
        ClickSearchUseCase(defValue = get())
    }

    factory<ScrollToBottomUseCase> {
        ScrollToBottomUseCase(defValue = get())
    }

    factory<DefValue> {
        DefValue()
    }

}