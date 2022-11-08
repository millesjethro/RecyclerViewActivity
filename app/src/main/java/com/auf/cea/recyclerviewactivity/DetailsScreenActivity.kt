package com.auf.cea.recyclerviewactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.auf.cea.recyclerviewactivity.databinding.ActivityDetailsScreenBinding

class DetailsScreenActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailsScreenBinding
    lateinit var imageId : Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        var bookinfo = arrayListOf(
            intent.getSerializableExtra("BookName"),
            intent.getSerializableExtra("Author"),
            intent.getSerializableExtra("ShortDesc"),
            intent.getSerializableExtra("LongDesc"),
            intent.getSerializableExtra("PubDate")
        )
        val mIntent = intent
        val intValue = mIntent.getIntExtra("ImageNum", 0)

        supportActionBar?.title = bookinfo[0].toString()
        binding.txtActName.text = "Book Title: "+bookinfo[0].toString()
        binding.txtauthornamedetails.text = "Book Author: "+bookinfo[1].toString()
        binding.txtActShortdesc.text = bookinfo[2].toString()
        binding.txtactlongdesc.text = bookinfo[3].toString()
        binding.txtactdatepub.text = "Date Published: "+bookinfo[4]
        binding.imgactdeetails.setImageResource(imageId[intValue])
        binding.btnback.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btnback)->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}