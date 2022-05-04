package com.zai.job.ui.vacancy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zai.job.databinding.ActivityVacancyDetailBinding

class VacancyDetail : AppCompatActivity() {
    private var _binding: ActivityVacancyDetailBinding? = null
    private val binding get() = _binding!!

    companion object{
        const val EXTRA_IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityVacancyDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val image = binding.vDetail
        image.setImageResource(intent.getIntExtra(EXTRA_IMAGE, 0))
    }
}