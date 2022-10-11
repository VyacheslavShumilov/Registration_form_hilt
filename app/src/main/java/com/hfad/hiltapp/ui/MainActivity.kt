package com.hfad.hiltapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.hiltapp.App
import com.hfad.hiltapp.databinding.ActivityMainBinding
import com.hfad.hiltapp.navigator.AppNavigator
import com.hfad.hiltapp.navigator.Screen

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Инициализация AppNavigator, в данном случае - для перехода в фрагмент по умолчанию
        navigator = (applicationContext as App).servicesLocator.providerNavigator(this)

        // TODO: Старотовый Фрагмент по умолчанию.
        if (savedInstanceState == null) {
            navigator.navigateTo(Screen.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}