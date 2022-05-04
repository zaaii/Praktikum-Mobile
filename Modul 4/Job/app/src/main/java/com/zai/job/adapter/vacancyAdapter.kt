package com.zai.job.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.zai.job.R
import com.zai.job.model.vacancyData
import com.zai.job.ui.vacancy.VacancyDetail
import com.zai.job.ui.vacancy.VacancyViewModel

class vacancyAdapter (
    private val context: Context,
    private val dataset: List<vacancyData>
): RecyclerView.Adapter<vacancyAdapter.VacancyViewHolder>() {
    private val viewModel = VacancyViewModel()

    class VacancyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.vacancy_item, parent, false)
        return VacancyViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)

        holder.view.setOnClickListener {
            viewModel.setData(item)
            val intent = Intent(context, VacancyDetail::class.java).apply {
                putExtra("image", viewModel.image.value)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size
}