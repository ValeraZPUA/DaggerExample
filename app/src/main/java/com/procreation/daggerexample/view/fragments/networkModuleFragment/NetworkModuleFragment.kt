package com.procreation.daggerexample.view.fragments.networkModuleFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.procreation.daggerexample.R
import com.procreation.daggerexample.api.responseObjects.EventModel
import com.procreation.daggerexample.view.fragments.preferencesModuleFragment.PreferencesModuleAdapter
import com.procreation.daggerexample.view.fragments.preferencesModuleFragment.PreferencesModuleFragmentPresenter
import kotlinx.android.synthetic.main.fragment_network_module.*

/**
 * A simple [Fragment] subclass.
 */
class NetworkModuleFragment : MvpAppCompatFragment(), NetworkModuleFragmentView {

    @InjectPresenter
    lateinit var presenter: PreferencesModuleFragmentPresenter

    private var mList = ArrayList<EventModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PreferencesModuleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_network_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = recycler_view
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager

        btn_retrofit.setOnClickListener {
            presenter.getData()
        }

    }

    override fun setList(list: List<EventModel>?) {
        mList.addAll(list!!)
        adapter =
            PreferencesModuleAdapter(
                mList
            )
        recyclerView.adapter = adapter
    }
}
