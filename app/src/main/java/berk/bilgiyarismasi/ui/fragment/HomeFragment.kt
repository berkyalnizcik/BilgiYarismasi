package berk.bilgiyarismasi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import berk.bilgiyarismasi.R
import berk.bilgiyarismasi.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_questionListFragment)
        }
    }
}