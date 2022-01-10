package berk.bilgiyarismasi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import berk.bilgiyarismasi.data.local.dao.AnswerDao
import berk.bilgiyarismasi.data.local.dao.QuestionDao
import berk.bilgiyarismasi.model.Answer
import berk.bilgiyarismasi.model.Question
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(
    entities = [Question::class, Answer::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @DelicateCoroutinesApi
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(createCallBack)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        @DelicateCoroutinesApi
        private val createCallBack = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                GlobalScope.launch {
                    Resources.getQuestionList().forEach { _pair ->
                        INSTANCE?.let {
                            it.questionDao().insertQuestion(_pair.first)
                            it.answerDao().insertAnswer(_pair.second[0])
                            it.answerDao().insertAnswer(_pair.second[1])
                            it.answerDao().insertAnswer(_pair.second[2])
                            it.answerDao().insertAnswer(_pair.second[3])
                        }
                    }
                }
            }
        }
    }
}