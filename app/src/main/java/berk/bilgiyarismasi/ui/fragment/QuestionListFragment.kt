package berk.bilgiyarismasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import berk.bilgiyarismasi.R
import berk.bilgiyarismasi.data.local.AppDatabase
import berk.bilgiyarismasi.data.local.relation.QuestionAnswer
import berk.bilgiyarismasi.data.repository.Repository
import berk.bilgiyarismasi.databinding.FragmentQuestionListBinding
import berk.bilgiyarismasi.ui.adapter.QuestionListAdapter
import berk.bilgiyarismasi.ui.viewmodel.QuestionListViewModel
import berk.bilgiyarismasi.ui.viewmodel.QuestionListViewModelFactory
import kotlin.properties.Delegates


class QuestionListFragment :
    BaseFragment<FragmentQuestionListBinding>(FragmentQuestionListBinding::inflate) {

    private val appDatabase by lazy {
        AppDatabase.getDatabase(requireContext())
    }
    private val questionDao by lazy {
        appDatabase.questionDao()
    }
    private val repository by lazy {
        Repository(questionDao)
    }
    private val questionListViewModel: QuestionListViewModel by viewModels {
        QuestionListViewModelFactory(repository)
    }
    private var list = listOf<QuestionAnswer>()

    private val questionViewPagerAdapter = QuestionListAdapter(::onCorrectOption, ::onWrongOption)

    private var rightAnswerCount by Delegates.observable(0) { _, _, newValue ->
        Log.e("TAG", "DOGRU CEVAP $newValue: ")
    }
    private var falseAnswerCount by Delegates.observable(0) { _, _, newValue ->
        Log.e("TAG", "YANLIS CEVAP $newValue: ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initViewPager()
        navigationButtons()
    }

    private fun navigationButtons() {
        with(binding) {
            lottieArrowDown.setOnClickListener { swipeViewPager(false) }
            lottieArrowUp.setOnClickListener { swipeViewPager(true) }
        }
    }

    private fun initViewPager() {
        with(binding.viewPagerQuestions) {
            adapter = questionViewPagerAdapter
            questionListViewModel.questionAnswerList.observe(viewLifecycleOwner) {
                list = it
                questionViewPagerAdapter.setNewList(it)
                checkViewPagerState(0)
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    checkViewPagerState(position)
                }
            })
        }
    }

    fun checkViewPagerState(position: Int) {
        with(binding) {
            tvPagePosition.text = getString(R.string.question_position, position + 1, list.size)
            lottieArrowDown.isVisible = list.size - 1 != position
            lottieArrowUp.isVisible = 0 != position
            if (position == list.size - 1) {
                onNavigateResult()
            }
        }
    }

    private fun swipeViewPager(isUp: Boolean) {
        val currentViewPagerPosition = binding.viewPagerQuestions.currentItem
        binding.viewPagerQuestions.setCurrentItem(
            if (isUp) currentViewPagerPosition - 1
            else currentViewPagerPosition + 1, true
        )
    }

    private fun onCorrectOption() {
        rightAnswerCount++
    }

    private fun onWrongOption() {
        falseAnswerCount++
    }

    private fun onNavigateResult() {
        with(binding) {
            btnShowToMyResult.visibility = View.VISIBLE
            btnShowToMyResult.setOnClickListener {
                val action =
                    QuestionListFragmentDirections.actionQuestionListFragmentToResultFragment(
                        rightAnswerCount,
                        falseAnswerCount
                    )
                findNavController().navigate(action)
            }
        }
    }
}