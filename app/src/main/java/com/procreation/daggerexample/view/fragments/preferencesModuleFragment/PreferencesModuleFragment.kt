package com.procreation.daggerexample.view.fragments.preferencesModuleFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.procreation.daggerexample.R
import com.procreation.daggerexample.view.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_preferences_module.*

class PreferencesModuleFragment : MvpAppCompatFragment(),
    PreferencesModuleFragmentView {

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



        btn_save.setOnClickListener {
            presenter.saveData(edit_text.text.toString())

        }

        btn_load.setOnClickListener {
            presenter.loadData()
        }

    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun setTextView(text: String?) {
        text_view.text = text
    }
}
