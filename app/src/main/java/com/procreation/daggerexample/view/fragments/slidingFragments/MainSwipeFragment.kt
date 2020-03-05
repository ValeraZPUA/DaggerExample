package com.procreation.daggerexample.view.fragments.slidingFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.procreation.daggerexample.R
import com.procreation.daggerexample.view.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_main_swipe.*


class MainSwipeFragment : Fragment(), View.OnTouchListener {

    private var fromPosition: Int = 0
    private var toPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).supportActionBar!!.title = getString(R.string.swipe_fragment)
        return inflater.inflate(R.layout.fragment_main_swipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_main_swipe.setOnTouchListener(this)

        val inflater = requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        val layouts = intArrayOf(R.layout.fragment_first_swipe, R.layout.fragment_second_swipe, R.layout.fragment_third_swipe)
        for (layout in layouts) {
            flipper.addView(inflater!!.inflate(layout, null))
        }
    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN ->
                fromPosition = event.x.toInt()
            MotionEvent.ACTION_UP -> {
                toPosition = event.x.toInt()

                if (fromPosition > toPosition) {
                    flipper.inAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.go_next_in)
                    flipper.outAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.go_next_out)
                    flipper.showNext()
                } else if (fromPosition < toPosition){
                    flipper.inAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.go_prev_in)
                    flipper.outAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.go_prev_out)
                    flipper.showPrevious()
                }
            }
        }
        return true
    }
}
