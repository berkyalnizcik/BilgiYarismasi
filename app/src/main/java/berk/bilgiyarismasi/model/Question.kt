package berk.bilgiyarismasi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val questionDesc: String
)