package com.procreation.daggerexample.view.fragments.multiTouchFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.procreation.daggerexample.R
import com.procreation.daggerexample.view.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_multi_touch.*

class MultiTouchFragment : Fragment(), View.OnTouchListener {

    private lateinit var tv: TextView

    var upPI = 0
    var downPI = 0
    var inTouch = false
    private lateinit var result: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_multi_touch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar!!.title =
            getString(R.string.multi_touch_fragment)

        tv = view.findViewById(R.id.text_view_multi_touch_fragment)
        fragment_multi_touch.setOnTouchListener(this)
    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {

        val sb = StringBuilder()

        //action
        val actionMask: Int = event!!.actionMasked
        //touch's index
        val pointerIndex: Int = event.actionIndex
        //touch's quantity
        val pointerCount: Int = event.pointerCount

        when (actionMask) {
            MotionEvent.ACTION_DOWN -> {
                inTouch = true
                downPI = pointerIndex
            }
            MotionEvent.ACTION_POINTER_DOWN -> downPI = pointerIndex
            MotionEvent.ACTION_UP -> {
                inTouch = false
                sb.setLength(0)
                upPI = pointerIndex
            }
            MotionEvent.ACTION_POINTER_UP -> upPI = pointerIndex
            MotionEvent.ACTION_MOVE -> {
                sb.setLength(0)
                var i = 0
                while (i < 5) {
                    sb.append("Index = $i")
                    if (i < pointerCount) {
                        sb.append(", ID = " + event.getPointerId(i))
                        sb.append(", X = " + event.getX(i))
                        sb.append(", Y = " + event.getY(i))
                    } else {
                        sb.append(", ID = ")
                        sb.append(", X = ")
                        sb.append(", Y = ")
                    }
                    sb.append("\r\n")
                    i++
                }
            }
        }
        result = """
            down: ${downPI}
            up: ${upPI}
            
            """.trimIndent()

        if (inTouch) {
            result += """
                pointerCount = $pointerCount
                ${sb.toString()}
                """.trimIndent()
        }
        tv.text = result

        return true
    }
}
