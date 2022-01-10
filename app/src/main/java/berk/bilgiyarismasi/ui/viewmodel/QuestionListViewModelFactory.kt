package berk.bilgiyarismasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import berk.bilgiyarismasi.data.repository.Repository

class QuestionListViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestionListViewModel(repository) as T
        }
        throw IllegalArgumentException("error")
    }
}