package berk.bilgiyarismasi.data.local

import berk.bilgiyarismasi.model.Answer
import berk.bilgiyarismasi.model.Question

object Resources {

    fun getQuestionList(): List<Pair<Question, List<Answer>>> {
        val tempList = arrayListOf<Pair<Question, List<Answer>>>()

        val question1 = Question(
            1L,
            "Satrançta geriye doğru hareket edemeyen taş hangisidir?"
        )
        val answer1 = Answer(
            1L,
            "Kale",
            false,
            1L
        )
        val answer2 = Answer(
            2L,
            "Piyon",
            true,
            1L
        )
        val answer3 = Answer(
            3L,
            "Şah",
            false,
            1L
        )
        val answer4 = Answer(
            4L,
            "At",
            false,
            1L
        )
        val question2 = Question(
            2L,
            "Mutluluk verici bir olay karşısında ağlayan kişilerin gözyaşları hangi sözle ifade edilir?"
        )
        val answer5 = Answer(
            5L,
            "Umut gözyaşları",
            false,
            2L
        )
        val answer6 = Answer(
            6L,
            "Timsah gözyaşları",
            false,
            2L
        )
        val answer7 = Answer(
            7L,
            "Umutsuzluk gözyaşları",
            false,
            2L
        )
        val answer8 = Answer(
            8L,
            "Sevinç gözyaşları",
            true,
            2L
        )
        val question3 = Question(
            3L,
            "Binlerce kişinin öldüğü Panama Kanalı inşaatında işçi olarak çalışan dünyaca ünlü ressam kimdir?"
        )
        val answer9 = Answer(
            9L,
            "Paul Gauguin",
            true,
            3L
        )
        val answer10 = Answer(
            10L,
            "Van Gogh",
            false,
            3L
        )
        val answer11 = Answer(
            11L,
            "Gustav Klimt",
            false,
            3L
        )
        val answer12 = Answer(
            12L,
            "Leonardo da Vinci",
            false,
            3L
        )
        val question4 = Question(
            4L,
            "“Sinekli Bakkal” romanının yazarı aşağıdakilerden hangisidir?"
        )
        val answer13 = Answer(
            13L,
            "Reşat Nuri Güntekin",
            false,
            4L
        )
        val answer14 = Answer(
            14L,
            "Halide Edip Adıvar",
            true,
            4L
        )
        val answer15 = Answer(
            15L,
            "Ziya Gökalp",
            false,
            4L
        )
        val answer16 = Answer(
            16L,
            "Ömer Seyfettin",
            false,
            4L
        )
        val question5 = Question(
            5L,
            "Aşağıda verilen ilk çağ uygarlıklarından hangisi yazıyı icat etmiştir?"
        )
        val answer17 = Answer(
            17L,
            "Hititler",
            false,
            5L
        )
        val answer18 = Answer(
            18L,
            "Elamlar",
            false,
            5L
        )
        val answer19 = Answer(
            19L,
            "Sümerler",
            true,
            5L
        )
        val answer20 = Answer(
            20L,
            "Urartular",
            false,
            5L
        )

        val pair1 = Pair(question1, listOf(answer1, answer2, answer3, answer4))
        val pair2 = Pair(question2, listOf(answer5, answer6, answer7, answer8))
        val pair3 = Pair(question3, listOf(answer9, answer10, answer11, answer12))
        val pair4 = Pair(question4, listOf(answer13, answer14, answer15, answer16))
        val pair5 = Pair(question5, listOf(answer17, answer18, answer19, answer20))
        tempList.add(pair1)
        tempList.add(pair2)
        tempList.add(pair3)
        tempList.add(pair4)
        tempList.add(pair5)
        return tempList
    }
}