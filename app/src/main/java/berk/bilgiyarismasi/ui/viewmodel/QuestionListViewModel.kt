package berk.bilgiyarismasi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import berk.bilgiyarismasi.data.local.relation.QuestionAnswer
import berk.bilgiyarismasi.data.repository.Repository

class QuestionListViewModel(
    repository: Repository
) : ViewModel() {

    val questionAnswerList: LiveData<List<QuestionAnswer>> =
        repository.getAllQuestionAndAnswer()
}