package com.camc.tvcanal.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.camc.tvcanal.databinding.FragmentViewTvBinding
import com.camc.tvcanal.ui.tv.viewmodel.TVViewModel


class TVFragment: Fragment(){
    private val canalViewModel: TVViewModel by activityViewModels {
        TVViewModel.Factory
    }


    private lateinit var binding : FragmentViewTvBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = canalViewModel
    }
}