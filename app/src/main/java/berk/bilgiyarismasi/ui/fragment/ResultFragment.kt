package berk.bilgiyarismasi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import berk.bilgiyarismasi.R
import berk.bilgiyarismasi.databinding.FragmentResultBinding

class ResultFragment : BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {
    private val args: ResultFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showResults()
        onClick()
    }

    private fun showResults() {
        val totalRightAnswerCount = args.rightAnswers
        val totalFalseAnswerCount = args.falseAnswers
        with(binding) {
            tvRightAnswers.text = totalRightAnswerCount.toString()
            tvFalseAnswers.text = totalFalseAnswerCount.toString()
        }
    }

    private fun onClick() {
        binding.btnBackToQuestion.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_questionListFragment)
        }
    }
}