package com.hfad.hiltapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.hiltapp.App
import com.hfad.hiltapp.data.DataSource
import com.hfad.hiltapp.data.User
import com.hfad.hiltapp.databinding.FragmentEditBinding
import com.hfad.hiltapp.navigator.AppNavigatorPar
import com.hfad.hiltapp.navigator.ScreenPar


class EditFragment(var user: User) : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private lateinit var looper: DataSource
    private lateinit var appNavigatorPar: AppNavigatorPar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        looper = (context.applicationContext as App).servicesLocator.logDataSource
        appNavigatorPar = (context.applicationContext as App).servicesLocator.providerNavigatorPar(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            idTextView.text = user.id.toString()
            firstNameTextView.text = user.firstName
            lastNameTextView.text = user.lastname
            phoneTextView.text = user.phone.toString()
        }

        binding.deleteUser.setOnClickListener {
            looper.removeOneUser(user)
        }

        binding.editDataUser.setOnClickListener {
            appNavigatorPar.navigateToParameters(ScreenPar.ONE_LOGS, user)
        }

    }
}