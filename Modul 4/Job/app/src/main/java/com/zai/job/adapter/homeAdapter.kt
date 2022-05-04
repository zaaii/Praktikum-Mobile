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
import com.zai.job.model.homeData
import com.zai.job.ui.home.HomeDetail
import com.zai.job.ui.home.HomeViewModel

class homeAdapter (
    private val context: Context,
    private val dataset: List<homeData>
    ) : RecyclerView.Adapter<homeAdapter.HomeViewHolder>() {
        private val viewModel = HomeViewModel()

        class HomeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            val imageView: ImageView = view.findViewById(R.id.imageV)
            val nameText: TextView = view.findViewById(R.id.Jname)
            val gajiText: TextView = view.findViewById(R.id.Jgaji)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
            val adapterLayout = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.home_item, parent, false)
            return HomeViewHolder(adapterLayout)
        }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
            val item = dataset[position]
            holder.imageView.setImageResource(item.imageResourceId)
            holder.nameText.text = context.resources.getString(item.nameResourceId)
            holder.gajiText.text = context.resources.getString(item.gajiResourceId)

            holder.view.setOnClickListener {
                viewModel.setData(item, context)
                val intent = Intent(context, HomeDetail::class.java).apply {
                    putExtra("image", viewModel.image.value)
                    putExtra("name", viewModel.name.value)
                    putExtra("gaji", viewModel.gaji.value)
                    putExtra("desc", viewModel.desc.value)
                }
                context.startActivity(intent)
            }
        }

        override fun getItemCount() = dataset.size
}