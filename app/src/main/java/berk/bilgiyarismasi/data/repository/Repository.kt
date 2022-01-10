package berk.bilgiyarismasi.data.repository

import berk.bilgiyarismasi.data.local.dao.QuestionDao

class Repository(
    private val questionDao: QuestionDao,
    // private val answerDao: AnswerDao
) {
    fun getAllQuestionAndAnswer() = questionDao.getAllQuestionAndAnswer()
/*  // if you want to use this functions, You can clear comment line and use them
    suspend fun insertQuestion(question: Question) = questionDao.insertQuestion(question)
    suspend fun deleteQuestion(question: Question) = questionDao.deleteQuestion(question)
    suspend fun updateQuestion(question: Question) = questionDao.updateQuestion(question)
    suspend fun insertAnswer(answer: Answer) = answerDao.insertAnswer(answer)
    suspend fun deleteAnswer(answer: Answer) = answerDao.deleteAnswer(answer)
    suspend fun updateAnswer(answer: Answer) = answerDao.updateAnswer(answer) */
}