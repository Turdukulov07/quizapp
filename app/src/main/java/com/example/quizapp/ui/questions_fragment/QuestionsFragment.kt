package com.example.quizapp.ui.questions_fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.QuestionFragmentBinding
import com.example.quizapp.models.Question
import com.example.quizapp.ui.questions_fragment.recycler.CustomLinearLayoutManager
import com.example.quizapp.ui.questions_fragment.recycler.OnButtonClick
import com.example.quizapp.ui.questions_fragment.recycler.QuestionsAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestionsFragment : Fragment(), OnButtonClick {

    private lateinit var binding: QuestionFragmentBinding
    private val layoutManager by lazy { CustomLinearLayoutManager(context) }

    private val mViewModel: QuestionViewModel by viewModel()
    private var position: Int = 0

    private var questionsAdapter = QuestionsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuestionFragmentBinding.inflate(inflater)
        setUpLiveData()
        setUpRecycler()
        return binding.root
    }

    private fun setUpLiveData() {
        mViewModel.getQuiz()
        mViewModel.quizLiveData.observe(viewLifecycleOwner) {
            questionsAdapter.submitList(it.result)
        }
    }

    private fun setUpRecycler() {
        layoutManager.orientation = RecyclerView.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = questionsAdapter
    }

    override fun onBtnAnswerClick(view: View, item: Question, answer: String) {
        val btn: Button = view as Button
        Log.e("TAG", "onBtnAnswerClick: {${item.answer}} ")
        lifecycleScope.launch {
            btn.setTextColor(Color.WHITE)
            view.setBackgroundColor(Color.BLUE)
            delay(500)
            if (view.text == item.correctAnswer)
                btn.setBackgroundColor(Color.GREEN)
            else btn.setBackgroundColor(Color.RED)
            scrollToPosition()
        }
    }

    override fun onBtnSkipClick(view: View, item: Question) {
        Log.e("TAG", "onBtnSkipClick: {${item.answer}} ")
        val btn: Button = view as Button
        btn.setTextColor(Color.WHITE)
        item.isSkipped = true
        questionsAdapter.notifyDataSetChanged()
        scrollToPosition()
    }

    private fun scrollToPosition() {
        lifecycleScope.launch {
            delay(500)
            layoutManager.setScrollEnabled(true)
            binding.recyclerView.smoothScrollToPosition(position++)
            delay(500)
            layoutManager.setScrollEnabled(false)
        }
    }
}



