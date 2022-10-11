package com.hfad.hiltapp.navigator

import androidx.fragment.app.FragmentActivity
import com.hfad.hiltapp.R
import com.hfad.hiltapp.data.User
import com.hfad.hiltapp.ui.ButtonsFragment
import com.hfad.hiltapp.ui.EditFragment
import com.hfad.hiltapp.ui.UsersFragment
import com.hfad.hiltapp.ui.OneUserFragment


class AppNavigatorImpl(private var fragmentActivity: FragmentActivity) : AppNavigator,AppNavigatorPar {

    override fun navigateTo(screen: Screen) {
        val fragment = when (screen) {
            Screen.BUTTONS -> ButtonsFragment()
            Screen.LOGS -> UsersFragment()
        }

        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }

    override fun navigateToParameters(screen: ScreenPar, user: User) {
        val fragment = when(screen){
            ScreenPar.ONE_LOGS -> OneUserFragment(user)
            ScreenPar.EDIT -> EditFragment(user)
        }

        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}