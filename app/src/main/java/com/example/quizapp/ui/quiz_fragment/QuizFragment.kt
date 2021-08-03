package com.example.quizapp.ui.quiz_fragment

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.quizapp.R
import com.example.quizapp.core.ui.base.BaseFragment
import com.example.quizapp.databinding.QuizFragmentBinding
import com.example.quizapp.models.TriviaCategories
import org.koin.android.ext.android.inject

class QuizFragment :
    BaseFragment<QuizFragmentBinding, QuizViewModel>(QuizFragmentBinding::inflate),
    AdapterView.OnItemSelectedListener {
    override val viewModel by inject<QuizViewModel>()
    private var listCategories: List<TriviaCategories>? = null

    companion object {
        fun getInstance(): QuizFragment {
            return QuizFragment()
        }
    }

    override fun setUpUI() {
        setUpSeekbar()
        binding.btnStart.setOnClickListener { navigateTo(R.id.questionsFragment) }
        binding.spinnerDifficulty.onItemSelectedListener = this

    }

    private fun setUpSeekbar() {
        binding.seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
                binding.tvQuestionsAmount.text = seekbar?.progress.toString() }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(seekbar: SeekBar?) {
                binding.tvQuestionsAmount.text = seekbar?.progress.toString()
                viewModel.setQuestionNum(seekbar?.progress ?: 0)
            }
        })
    }

    override fun setUp() {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent?.id == binding.spinnerCategory.id) {
            viewModel.setCategory(listCategories?.get(position)?.id ?: 0)
        } else if (parent?.id == binding.spinnerDifficulty.id) {
            viewModel.setDifficulty(parent.getItemAtPosition(position) as String)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun setUpLiveData() {
        viewModel.getCategory().observe(viewLifecycleOwner) { category  ->

            listCategories = category.body()?.categories

            val categoryNameList = ArrayList<String>()

            category.body()?.categories?.map { it.name }?.let { it1 -> categoryNameList.addAll(it1) }

            setUpSpinnerCategoryAdapter(categoryNameList)
        }
    }

    private fun setUpSpinnerCategoryAdapter(categoryNameList: ArrayList<String>) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categoryNameList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategory.adapter = adapter
        binding.spinnerCategory.onItemSelectedListener = this
    }

}