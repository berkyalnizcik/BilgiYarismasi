package berk.bilgiyarismasi.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import berk.bilgiyarismasi.model.Answer
import berk.bilgiyarismasi.model.Question

data class QuestionAnswer(
    @Embedded
    val question: Question,
    @Relation(
        parentColumn = "id",
        entityColumn = "questionId"
    )
    val answerList: List<Answer>
)