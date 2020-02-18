package com.procreation.daggerexample.view.activities

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.procreation.daggerexample.R
import com.procreation.daggerexample.view.fragments.exampleFragment.ExampleFragment


class MainActivity : MvpAppCompatActivity(), MainActivityView {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,ExampleFragment(this)).commit()

        //navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun test(s: String) {
        Log.d("tag", "sfsdfsdf " + s)
    }
}
