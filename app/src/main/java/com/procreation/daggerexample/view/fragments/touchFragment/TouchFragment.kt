package com.procreation.daggerexample.view.fragments.touchFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.procreation.daggerexample.R
import com.procreation.daggerexample.view.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_touch.*


class TouchFragment : Fragment(), View.OnTouchListener {

    private lateinit var tv: TextView

    private lateinit var sDown: String
    private lateinit var sMove: String
    private lateinit var sUp: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_touch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar!!.title = getString(R.string.touch_fragment)

        tv = view.findViewById(R.id.text_view_touch_fragment)
        touch_fragment.setOnTouchListener(this)
    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        val x = event!!.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                sDown = "Down: $x,$y"
                sMove = ""
                sUp = ""
            }
            MotionEvent.ACTION_MOVE -> sMove = "Move: $x,$y"
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                sMove = ""
                sUp = "Up: $x,$y"
            }
        }
        tv.text = sDown + "\n" + sMove + "\n" + sUp
        return true
    }
}
