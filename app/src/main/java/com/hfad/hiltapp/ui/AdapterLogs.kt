package com.hfad.hiltapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.hiltapp.data.User
import com.hfad.hiltapp.databinding.ItemListLogsBinding

class AdapterLogs(
    private val user: List<User>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<AdapterLogs.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemListLogsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindView(user: User) {
            with(binding) {
                userId.text = user.id.toString()
                userFirstName.text = user.firstName
                userLastName.text = user.lastname
                itemView.setOnClickListener {
                    listener.onClick(user)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListLogsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(user[position])
    }

    override fun getItemCount(): Int = user.size

    interface OnClickListener{
        fun onClick(user: User) {
        }
    }
}