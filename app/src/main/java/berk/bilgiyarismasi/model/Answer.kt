package berk.bilgiyarismasi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Answer(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val answer: String,
    val isRightAnswer: Boolean,
    val questionId: Long
)