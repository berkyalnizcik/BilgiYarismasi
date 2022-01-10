package berk.bilgiyarismasi.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import berk.bilgiyarismasi.data.local.relation.QuestionAnswer
import berk.bilgiyarismasi.model.Question

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)

    @Delete
    suspend fun deleteQuestion(question: Question)

    @Update
    suspend fun updateQuestion(question: Question)

    @Transaction
    @Query("SELECT * FROM Question")
    fun getAllQuestionAndAnswer(): LiveData<List<QuestionAnswer>>
}