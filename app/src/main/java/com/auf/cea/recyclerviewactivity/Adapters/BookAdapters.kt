package com.auf.cea.recyclerviewactivity.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewactivity.DetailsScreenActivity
import com.auf.cea.recyclerviewactivity.R
import com.auf.cea.recyclerviewactivity.databinding.ContentSearchBinding
import com.auf.cea.recyclerviewactivity.dialogs.DetailsFragment
import com.auf.cea.recyclerviewactivity.models.BooksModel


class BookAdapters (private var booklist:ArrayList<BooksModel>, private var context: Context): RecyclerView.Adapter<BookAdapters.SearchRVViewHolder>() {
    lateinit var imageId : Array<Int>

   inner class SearchRVViewHolder(val binding: ContentSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(binding: ContentSearchBinding) {
            binding.buynow.setOnClickListener {
                val BooksModel = booklist[adapterPosition]
                val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(BooksModel.url))
                context.startActivity(urlIntent)
            }
            binding.btnDeatails.setOnClickListener {
                val BooksModel = booklist[adapterPosition]
                val intent = Intent(context, DetailsScreenActivity::class.java)
                intent.putExtra("BookName",BooksModel.name)
                intent.putExtra("Author",BooksModel.author)
                intent.putExtra("ShortDesc",BooksModel.shortDescription)
                intent.putExtra("LongDesc", BooksModel.description)
                intent.putExtra("PubDate",BooksModel.datePublished)
                intent.putExtra("ImageNum",BooksModel.imageID)
                context.startActivity(intent)
            }
            binding.btnview.setOnClickListener {
                val BooksModel = booklist[adapterPosition]
                val fm = (context as AppCompatActivity).supportFragmentManager
                val details = DetailsFragment()
                val bundle = Bundle()
                bundle.putString("BookName",BooksModel.name)
                bundle.putString("ShortDesc",BooksModel.shortDescription)
                bundle.putString("PubDate",BooksModel.datePublished)
                bundle.putInt("ImageNum",BooksModel.imageID)
                details.arguments = bundle
                details.show(fm,"Details Fragment")

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRVViewHolder {
        val binding = ContentSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchRVViewHolder, position: Int) {

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

        with(holder){
            holder.bind(holder.binding)
            with(booklist[position]){
                val BooksModel = booklist[adapterPosition]
                binding.txtName.text = this.name
                binding.txtbookpublish.text = "Book Published: "+this.datePublished
                binding.imageView.setImageResource(imageId[BooksModel.imageID])
            }
        }
    }

    override fun getItemCount(): Int {
        return booklist.size
    }
}