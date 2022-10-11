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
import com.hfad.hiltapp.databinding.FragmentUserOneBinding

class OneUserFragment(var user: User) : Fragment() {

    private lateinit var binding: FragmentUserOneBinding
    private lateinit var lopper: DataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        lopper = (context.applicationContext as App).servicesLocator.logDataSource
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            editFirstName.setText(user.firstName)
            editLastName.setText(user.lastname)
            editPhone.setText(user.phone.toString())

            editSaveChanges.setOnClickListener {

                lopper.editOneUser(
                    user.id,
                    editFirstName.text.toString(),
                    editLastName.text.toString(),
                    editPhone.text.toString().toLong()
                )
            }
        }
    }
}