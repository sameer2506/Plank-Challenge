package com.plank.challenge.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plank.challenge.R
import com.plank.challenge.database.AppPreferences
import com.plank.challenge.databinding.FragmentPlankDetailsBinding
import com.plank.challenge.ui.activity.HomeActivity

class PlankDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPlankDetailsBinding
    private lateinit var appPreferences: AppPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlankDetailsBinding.inflate(layoutInflater)
        appPreferences = AppPreferences(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val level = appPreferences.getLevel()

        binding.textView10.text = level.toString()

        when (level) {
            1 -> {
                val plankLevel = "PLANK BEGINNER"
                binding.textView8.text = plankLevel
            }
            2 -> {
                val plankLevel = "PLANK INTERMEDIATE"
                binding.textView8.text = plankLevel
            }
            3 -> {
                val plankLevel = "PLANK EXPERT"
                binding.textView8.text = plankLevel
            }
        }

        binding.btnStart.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
            requireActivity().finish()
        }
    }

}