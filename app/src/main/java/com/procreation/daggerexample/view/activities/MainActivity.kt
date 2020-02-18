package com.procreation.daggerexample.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.procreation.daggerexample.R
import com.procreation.daggerexample.view.fragments.ExampleFragment


class MainActivity : MvpAppCompatActivity(), MainActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ExampleFragment()).commit()
    }

}
