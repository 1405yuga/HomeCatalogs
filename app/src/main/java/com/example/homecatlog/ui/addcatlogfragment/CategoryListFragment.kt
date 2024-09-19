package com.example.homecatlog.ui.addcatlogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.homecatlog.R
import com.example.homecatlog.databinding.FragmentCategoryListBinding
import com.example.homecatlog.network.BaseApplication
import com.example.homecatlog.ui.CatalogViewModel

class CategoryListFragment : Fragment() {

    private lateinit var binding: FragmentCategoryListBinding
    private val viewModel: CatalogViewModel by activityViewModels {
        CatalogViewModel.CatalogViewModelFactory((activity?.application as BaseApplication).database.getCatalogDao())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            addCatlog.setOnClickListener { navigateToFragment(R.id.addCatlogFragment) }
        }
    }

    private fun navigateToFragment(fragmentId: Int) {
        findNavController().apply {
            navigate(fragmentId)
        }
    }
}