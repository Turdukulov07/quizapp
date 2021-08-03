package com.example.quizapp.ui.questions_fragment.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ItemAnswerOptionsBinding
import com.example.quizapp.models.Question


class QuestionsAdapter
    (private val clickListener: OnButtonClick) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>() {
    private var list: MutableList<Question> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {

        val binding = ItemAnswerOptionsBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return QuestionsViewHolder(binding)
    }

    fun submitList(list: List<Question>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    inner class QuestionsViewHolder(
        private val binding: ItemAnswerOptionsBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Question, position: Int) {
            binding.item = item
            binding.listener = clickListener

            val buttons: List<Button> = listOf(
                binding.btnFirstOption, binding.btnSecondOption, binding.btnThirdOption,
                binding.btnForthOption, binding.btnFirstOption2, binding.btnSecondOption2
            )
            buttons.forEach { btn ->
//                if (item.isAnsweredCorrect && btn.text == item.correctAnswer)
//                    btn.setBackgroundColor(Color.GREEN)
//                if (item.isAnsweredIncorrect && btn.text == item.answer)
//                    btn.setBackgroundColor(Color.RED)
                if (item.isSkipped && btn.text == item.correctAnswer)
                    btn.setBackgroundColor(Color.GREEN)
            }
            binding.executePendingBindings()
        }
    }
}
