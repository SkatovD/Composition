package com.example.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.composition.R
import com.example.composition.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private var _binding: WelcomeFragmentBinding? = null
    private val binding: WelcomeFragmentBinding
        get() = _binding ?: throw java.lang.RuntimeException("binding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonUnderstand.setOnClickListener {
            launchChooseLevelFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchChooseLevelFragment() {

        findNavController().navigate(R.id.action_welcomeFragment_to_chooseLevelFragment)
    }
}