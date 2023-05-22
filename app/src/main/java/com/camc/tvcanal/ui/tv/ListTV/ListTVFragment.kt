package com.camc.tvcanal.ui.tv.ListTV

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.camc.tvcanal.R
import com.camc.tvcanal.data.model.TVModel
import com.camc.tvcanal.databinding.FragmentListTvBinding
import com.camc.tvcanal.ui.tv.ListTV.recyclerview.TVRecyclerViewAdapter
import com.camc.tvcanal.ui.tv.viewmodel.TVViewModel

class ListTVFragment : Fragment(){
    private val movieViewModel: TVViewModel by activityViewModels {
        TVViewModel.Factory
    }
    private lateinit var adapter: TVRecyclerViewAdapter

    private lateinit var binding: FragmentListTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)


    }
    private fun showSelectedItem(movie: TVModel){
        movieViewModel.setSelectedCanal(movie)
        findNavController().navigate(R.id.action_listTVFragment_to_viewTVFragment)
    }

    private fun setRecyclerView(view: View){
        binding.recycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = TVRecyclerViewAdapter{ selectedCanal ->
            showSelectedItem(selectedCanal)
        }

        binding.recycleView.adapter = adapter
        displayMovies()
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getCanal())
        adapter.notifyDataSetChanged()
    }

}