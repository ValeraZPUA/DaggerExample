package com.procreation.daggerexample.view.fragments.networkModuleFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.procreation.daggerexample.R
import com.procreation.daggerexample.api.responseObjects.EventModel
import kotlinx.android.synthetic.main.rv_item.view.*

class NetworkModuleAdapter(
    private var posts: List<EventModel>
) : RecyclerView.Adapter<NetworkModuleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = posts[position]
        holder.bind(item)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val text: TextView = view.tv_in_rv

        fun bind(item: EventModel) {
            text.text = item.title
        }
    }
}