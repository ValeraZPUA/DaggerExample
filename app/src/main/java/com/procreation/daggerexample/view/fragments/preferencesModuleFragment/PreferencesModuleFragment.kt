package com.procreation.daggerexample.view.fragments.preferencesModuleFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.procreation.daggerexample.R
import com.procreation.daggerexample.api.responseObjects.EventModel
import com.procreation.daggerexample.view.activities.MainActivity
import com.procreation.daggerexample.view.activities.MainActivityView
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_preferences_module.*


class PreferencesModuleFragment : MvpAppCompatFragment(),
    PreferencesModuleFragmentView {

    private var mList = ArrayList<EventModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PreferencesModuleAdapter


    @InjectPresenter
    lateinit var presenter: PreferencesModuleFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_preferences_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar!!.title = getString(R.string.preferences_module)

        recyclerView = recycler_view
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager

        btn_save.setOnClickListener {
            presenter.saveData(edit_text.text.toString())

        }

        btn_load.setOnClickListener {
            text_view.text = presenter.loadData().toString()
        }

        btn_retrofit.setOnClickListener {
            presenter.getData()
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
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
