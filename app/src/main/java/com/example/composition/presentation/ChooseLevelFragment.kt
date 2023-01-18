package com.example.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composition.R
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
            buttonTestLevel.setOnClickListener {
                launchGameFragmentLevel(Level.EASY)
            }
            buttonTestLevel.setOnClickListener {
                launchGameFragmentLevel(Level.MEDIUM)
            }
            buttonTestLevel.setOnClickListener {
                launchGameFragmentLevel(Level.HARD)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val NAME = "ChooseLevelFragment"
        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }

    }


    private fun launchGameFragmentLevel(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commit()
    }


}