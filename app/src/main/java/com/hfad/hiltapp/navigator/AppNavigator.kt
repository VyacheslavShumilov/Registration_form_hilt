package com.hfad.hiltapp.navigator

import com.hfad.hiltapp.data.User


enum class Screen {
    BUTTONS,
    LOGS
}

interface AppNavigator {
    fun navigateTo(screen: Screen)
}

enum class ScreenPar {
    ONE_LOGS,
    EDIT
}

interface AppNavigatorPar {
    fun navigateToParameters(screen: ScreenPar, user: User)
}