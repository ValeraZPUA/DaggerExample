package com.procreation.daggerexample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.procreation.daggerexample.R
import com.procreation.daggerexample.models.EventModel
import kotlinx.android.synthetic.main.fragment_example.*


class ExampleFragment : MvpAppCompatFragment(), ExampleFragmentView {

    private var mList = ArrayList<EventModel>()

    @InjectPresenter
    lateinit var presenter: ExampleFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        text_view_retrofit.text = list[0].title
    }


}
