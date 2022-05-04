package com.zai.job.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zai.job.R
import com.zai.job.model.newsData
import com.zai.job.ui.home.HomeDetail
import com.zai.job.ui.news.NewsDetail
import com.zai.job.ui.news.NewsViewModel


class newsAdapter (
    private val context: Context,
    private val dataset: List<newsData>
) : RecyclerView.Adapter<newsAdapter.NewsViewHolder>() {
    private val viewModel = NewsViewModel()

    class NewsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.nImage)
        val titleText: TextView = view.findViewById(R.id.judulN)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.titleText.text = context.resources.getString(item.titleResourceId)

        holder.view.setOnClickListener {
            viewModel.setData(item, context)
            val intent = Intent(context, NewsDetail::class.java).apply {
                putExtra("image", viewModel.image.value)
                putExtra("title", viewModel.title.value)
                putExtra("desc", viewModel.desc.value)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size
}