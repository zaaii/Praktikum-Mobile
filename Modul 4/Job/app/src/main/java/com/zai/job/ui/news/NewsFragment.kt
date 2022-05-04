package com.zai.job.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zai.job.adapter.homeAdapter
import com.zai.job.adapter.newsAdapter
import com.zai.job.databinding.FragmentHomeBinding
import com.zai.job.databinding.FragmentNewsBinding
import com.zai.job.ui.home.HomeViewModel

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.NewsFrag
        recyclerView.adapter = newsAdapter(requireContext(), NewsViewModel().LoadData())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
