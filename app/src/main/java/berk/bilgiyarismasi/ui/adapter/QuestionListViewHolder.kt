package berk.bilgiyarismasi.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import berk.bilgiyarismasi.R
import berk.bilgiyarismasi.data.local.relation.QuestionAnswer
import berk.bilgiyarismasi.databinding.ItemQuestionListBinding
import berk.bilgiyarismasi.util.extensions.changeViewGroupState

class QuestionListViewHolder(
    private val binding: ItemQuestionListBinding, private val listener: Listener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: QuestionAnswer) {
        enableHolderRoot()
        with(binding) {
            tvQuestion.text = item.question.questionDesc
            with(btnA) {
                text = root.resources.getString(
                    R.string.answer_position,
                    OPTION_A,
                    item.answerList[0].answer
                )
                setOnClickListener {
                    disableHolderRoot()
                    if (item.answerList[0].isRightAnswer) {
                        setBackgroundColor(Color.GREEN)
                        listener.onCorrectOptionSelected()
                        return@setOnClickListener
                    } else {
                        setBackgroundColor(Color.RED)
                        listener.onWrongOptionSelected()
                        return@setOnClickListener
                    }
                }
            }
            with(btnB) {
                text = root.resources.getString(
                    R.string.answer_position,
                    OPTION_B,
                    item.answerList[1].answer
                )
                setOnClickListener {
                    disableHolderRoot()
                    if (item.answerList[1].isRightAnswer) {
                        setBackgroundColor(Color.GREEN)
                        listener.onCorrectOptionSelected()
                        return@setOnClickListener
                    } else {
                        setBackgroundColor(Color.RED)
                        listener.onWrongOptionSelected()
                        return@setOnClickListener
                    }
                }
            }
            with(btnC) {
                text = root.resources.getString(
                    R.string.answer_position,
                    OPTION_C,
                    item.answerList[2].answer
                )
                setOnClickListener {
                    disableHolderRoot()
                    if (item.answerList[2].isRightAnswer) {
                        setBackgroundColor(Color.GREEN)
                        listener.onCorrectOptionSelected()
                        return@setOnClickListener
                    } else {
                        setBackgroundColor(Color.RED)
                        listener.onWrongOptionSelected()
                        return@setOnClickListener
                    }
                }
            }
            with(btnD) {
                text = root.resources.getString(
                    R.string.answer_position,
                    OPTION_D,
                    item.answerList[3].answer
                )
                setOnClickListener {
                    disableHolderRoot()
                    if (item.answerList[3].isRightAnswer) {
                        setBackgroundColor(Color.GREEN)
                        listener.onCorrectOptionSelected()
                        return@setOnClickListener
                    } else {
                        setBackgroundColor(Color.RED)
                        listener.onWrongOptionSelected()
                        return@setOnClickListener
                    }
                }
            }
        }
    }

    private fun disableHolderRoot() {
        binding.container.changeViewGroupState(false)
    }

    private fun enableHolderRoot() {
        binding.container.changeViewGroupState(true)
    }

    interface Listener {
        fun onCorrectOptionSelected()
        fun onWrongOptionSelected()
    }

    companion object {
        private const val OPTION_A = "A\t"
        private const val OPTION_B = "B\t"
        private const val OPTION_C = "C\t"
        private const val OPTION_D = "D\t"
        fun create(parent: ViewGroup, listener: Listener): QuestionListViewHolder {
            val binding =
                ItemQuestionListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return QuestionListViewHolder(binding, listener)
        }
    }
}