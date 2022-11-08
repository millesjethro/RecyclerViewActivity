package com.auf.cea.recyclerviewactivity.dialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.auf.cea.recyclerviewactivity.R

class DetailsFragment : DialogFragment() {
    lateinit var imageId : Array<Int>
    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j
        )

        var rootView : View = inflater.inflate(R.layout.fragment_details,container,false)
        var closebutton = rootView.findViewById<Button>(R.id.btnclose)
        var txtname = rootView.findViewById<TextView>(R.id.txtName)
        var txtShortdesc = rootView.findViewById<TextView>(R.id.txtShortdesc)
        var txtdatepub = rootView.findViewById<TextView>(R.id.txtdatepub)
        var imageview = rootView.findViewById<ImageView>(R.id.imgFragDetials)

        var imageNumber = arguments?.getInt("ImageNum")
        if(arguments != null){
            txtname.text = (arguments?.getString("BookName"))
            txtShortdesc.text = (arguments?.getString("ShortDesc"))
            txtdatepub.text = "Book Published: "+(arguments?.getString("PubDate"))
            imageview.setImageResource(imageId[imageNumber!!])
        }
        closebutton.setOnClickListener { dismiss() }

        return rootView
    }
}