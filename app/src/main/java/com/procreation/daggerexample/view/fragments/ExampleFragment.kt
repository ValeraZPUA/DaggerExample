package com.procreation.daggerexample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.procreation.daggerexample.R
import kotlinx.android.synthetic.main.fragment_example.*


class ExampleFragment : MvpAppCompatFragment(), ExampleFragmentView {

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

    }

    override fun showToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* override fun showToast(message: String) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }*/
}
