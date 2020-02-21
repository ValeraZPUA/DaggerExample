package com.procreation.daggerexample.view.fragments.networkModuleFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.procreation.daggerexample.R
import com.procreation.daggerexample.api.responseObjects.EventModel
import com.procreation.daggerexample.view.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_network_module.*

class NetworkModuleFragment : MvpAppCompatFragment(), NetworkModuleFragmentView {

    @InjectPresenter
    lateinit var presenter: NetworkModuleFragmentPresenter

    private var mList = ArrayList<EventModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NetworkModuleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_network_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar!!.title = getString(R.string.network_module)

        recyclerView = recycler_view
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager

        btn_retrofit.setOnClickListener {
            presenter.getData()
        }
    }

    override fun setList(list: List<EventModel>?) {
        mList.addAll(list!!)
        adapter = NetworkModuleAdapter(mList)
        recyclerView.adapter = adapter
    }
}
