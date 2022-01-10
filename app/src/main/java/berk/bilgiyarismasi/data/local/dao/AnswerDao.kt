package berk.bilgiyarismasi.data.local.dao

import androidx.room.*
import berk.bilgiyarismasi.model.Answer

@Dao
interface AnswerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answer: Answer)

    @Delete
    suspend fun deleteAnswer(answer: Answer)

    @Update
    suspend fun updateAnswer(answer: Answer)
}