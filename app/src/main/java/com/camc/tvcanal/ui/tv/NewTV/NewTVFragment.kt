package com.camc.tvcanal.ui.tv.NewTV

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.camc.tvcanal.databinding.FragmentNewTvBinding
import com.camc.tvcanal.ui.tv.viewmodel.TVViewModel

class NewTVFragment : Fragment() {
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val canalViewModel: TVViewModel by activityViewModels {
        TVViewModel.Factory
    }

    private lateinit var binding : FragmentNewTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = canalViewModel
    }
    private fun observerStatus(){
        canalViewModel.status.observe(viewLifecycleOwner) {
                status -> when{
            status.equals(TVViewModel.WRONG_INFORMATION) -> {
                Log.d(APP_TAG, status)
                canalViewModel.clearStatus() }
            status.equals(TVViewModel.CANAL_CREATED) -> {
                Log.d(APP_TAG, status)
                Log.d(APP_TAG, canalViewModel.getCanal().toString())

                canalViewModel.clearStatus()
                findNavController().popBackStack() }
        }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}