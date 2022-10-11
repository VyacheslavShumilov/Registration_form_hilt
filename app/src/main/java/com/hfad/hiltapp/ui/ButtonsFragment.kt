package com.hfad.hiltapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hfad.hiltapp.App
import com.hfad.hiltapp.data.DataSource
import com.hfad.hiltapp.data.User
import com.hfad.hiltapp.databinding.FragmentButtonsBinding
import com.hfad.hiltapp.navigator.AppNavigator
import com.hfad.hiltapp.navigator.Screen

class ButtonsFragment : Fragment() {

    private lateinit var binding: FragmentButtonsBinding
    private lateinit var appNavigator: AppNavigator
    private lateinit var looper: DataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        looper = (context.applicationContext as App).servicesLocator.logDataSource
        appNavigator = (context.applicationContext as App).servicesLocator.providerNavigator(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            btnAdd.setOnClickListener {
                if (isSuccessful()) {
                    val user = User(
                        enterFirstName.text.toString(),
                        enterLastName.text.toString(),
                        enterPhone.text.toString().toLong()
                    )
                    looper.addUser(user)
                }
            }

            // TODO: переход в LogsFragment
            allUsers.setOnClickListener {
                appNavigator.navigateTo(Screen.LOGS)
            }

            deleteLogs.setOnClickListener {
                looper.removeAll()
            }
        }
    }

    private fun isSuccessful(): Boolean {
        if (binding.enterFirstName.text?.trim().toString().isEmpty()) {
            Toast.makeText(context, "Введите имя", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.enterLastName.text?.trim().toString().isEmpty()) {
            Toast.makeText(context, "Введите фамилию", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.enterPhone.text?.trim().toString().isEmpty()) {
            Toast.makeText(context, "Введите телефон", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}