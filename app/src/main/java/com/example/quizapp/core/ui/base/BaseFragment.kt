package com.example.quizapp.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, out VM : BaseViewModel>(
    val inflater: (LayoutInflater) -> VB
) : Fragment() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater(inflater)
        setUp()
        setUpLiveData()
        setUpUI()
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }



    protected open fun navigateTo(id: Int) {
        findNavController().navigate(id)
    }
    abstract fun setUpLiveData()
    abstract fun setUpUI()
     abstract fun setUp()



}