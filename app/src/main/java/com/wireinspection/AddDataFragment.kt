package com.wireinspection


import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class AddDataFragment : Fragment(), View.OnClickListener{


    lateinit var scrollView: ScrollView
    lateinit var slingId : TextInputEditText
    lateinit var measuredDiameter : TextInputEditText
    lateinit var kinks : TextInputEditText
    lateinit var crushed : TextInputEditText
    lateinit var birdcage1Lay : TextInputEditText
    lateinit var birdcage1Strand : TextInputEditText
    lateinit var brokenWire : TextInputEditText
    lateinit var heatDamage : TextInputEditText
    lateinit var endAttachmentFitting : TextInputEditText
    lateinit var endAttachmentBrokenWires : TextInputEditText
    lateinit var hookCondition : TextInputEditText
    lateinit var slingIsServiceable : TextInputEditText
    lateinit var slingIsRejected : TextInputEditText
    lateinit var comments : TextInputEditText
    lateinit var submit : Button
    val baseUrl: String = "http://192.168.1.153:3000/"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.add_data_fragment, container, false)
        val navHeight = arguments.getInt("navHeight")
        Log.i("Nav Height", "$navHeight")
        scrollView = view.findViewById(R.id.scroller)
        scrollView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val scrollHeight = scrollView.measuredHeight
                val newHeight = scrollHeight - navHeight
                scrollView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, newHeight)
                if (Build.VERSION.SDK_INT < 16) {
                    scrollView.viewTreeObserver.removeGlobalOnLayoutListener(this)
                } else {
                    scrollView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }

            }
        })
        slingId = view.findViewById(R.id.sling_id)
        measuredDiameter = view.findViewById(R.id.measured_diameter)
        kinks = view.findViewById(R.id.kinks)
        crushed = view.findViewById(R.id.crushed)
        birdcage1Lay = view.findViewById(R.id.birdcage_1_lay)
        birdcage1Strand = view.findViewById(R.id.birdcage_1_strand)
        brokenWire = view.findViewById(R.id.broken_wire)
        heatDamage = view.findViewById(R.id.heat_damage)
        endAttachmentFitting = view.findViewById(R.id.end_attachment_fitting)
        endAttachmentBrokenWires = view.findViewById(R.id.end_attachment_broken_wires)
        hookCondition = view.findViewById(R.id.hook_condition)
        slingIsServiceable = view.findViewById(R.id.sling_is_serviceable)
        slingIsRejected = view.findViewById(R.id.sling_is_rejected)
        comments = view.findViewById(R.id.comments)
        submit = view.findViewById(R.id.submit)

        submit.setOnClickListener(this)

        return view
    }
    override fun onClick(p0: View?) {
        callAPI().execute(URL(baseUrl+"" +
                "?slingId="+slingId.text +
                "&measuredDiameter="+measuredDiameter.text +
                "&kinks="+kinks.text +
                "&crushed="+crushed.text +
                "&birdcage1Lay="+birdcage1Lay.text +
                "&birdcage1Strand="+birdcage1Strand.text +
                "&brokenWire="+brokenWire.text +
                "&heatDamage="+heatDamage.text +
                "&endAttachmentFitting="+endAttachmentFitting.text +
                "&endAttachmentBrokenWires="+endAttachmentBrokenWires.text +
                "&hookCondition="+hookCondition.text +
                "&slingIsServiceable="+slingIsServiceable.text +
                "&slingIsRejected="+slingIsRejected.text +
                "&comments="+comments.text
        ))
    }

}

