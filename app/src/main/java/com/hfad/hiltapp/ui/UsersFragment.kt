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
import com.hfad.hiltapp.databinding.FragmentUsersBinding
import com.hfad.hiltapp.navigator.AppNavigatorPar
import com.hfad.hiltapp.navigator.ScreenPar

class UsersFragment : Fragment(), AdapterLogs.OnClickListener {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var lopper: DataSource
    private lateinit var appNavigator: AppNavigatorPar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // TODO: Для доступа к данным БД
        lopper = (context.applicationContext as App).servicesLocator.logDataSource


        // TODO: TODO: Инициализация AppNavigator, в данном случае - для перехода на фрагмент Screen.EDIT
        appNavigator = (context.applicationContext as App).servicesLocator.providerNavigatorPar(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.apply {
                setHasFixedSize(true)
            }

            lopper.getAllUsers { list ->
                val adapterLogs = AdapterLogs(list, this@UsersFragment)
                recyclerView.adapter = adapterLogs
            }
        }
    }


    override fun onClick(user: User) {
        appNavigator.navigateToParameters(ScreenPar.EDIT, user)
    }
}