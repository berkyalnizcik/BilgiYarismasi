package berk.bilgiyarismasi.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import berk.bilgiyarismasi.data.local.relation.QuestionAnswer

class QuestionListAdapter(
    private val onCorrectOptionSelected: () -> Unit, private val onWrongOptionSelected: () -> Unit
) : RecyclerView.Adapter<QuestionListViewHolder>() {

    private var list: List<QuestionAnswer> = emptyList()

    private val answerSelectionListener = object : QuestionListViewHolder.Listener {
        override fun onCorrectOptionSelected() {
            onCorrectOptionSelected.invoke()
        }

        override fun onWrongOptionSelected() {
            onWrongOptionSelected.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionListViewHolder {
        return QuestionListViewHolder.create(parent, answerSelectionListener)
    }

    override fun onBindViewHolder(holder: QuestionListViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewList(newList: List<QuestionAnswer>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}