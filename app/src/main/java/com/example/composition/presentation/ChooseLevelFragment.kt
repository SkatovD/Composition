package com.example.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.composition.databinding.ChoselevelFragmentBinding
import com.example.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {
    private var _binding: ChoselevelFragmentBinding? = null
    private val binding: ChoselevelFragmentBinding
        get() = _binding ?: throw java.lang.RuntimeException("binding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ChoselevelFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonTestLevel.setOnClickListener {
                launchGameFragmentLevel(Level.TEST)
            }
            buttonEasyLevel.setOnClickListener {
                launchGameFragmentLevel(Level.EASY)
            }
            buttonMediumLevel.setOnClickListener {
                launchGameFragmentLevel(Level.MEDIUM)
            }
            buttonHardLevel.setOnClickListener {
                launchGameFragmentLevel(Level.HARD)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGameFragmentLevel(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
                level
            )
        )
    }


}