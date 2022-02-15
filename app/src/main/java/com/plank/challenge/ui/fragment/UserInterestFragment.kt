package com.plank.challenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.plank.challenge.R
import com.plank.challenge.database.AppPreferences
import com.plank.challenge.databinding.FragmentUserInterestBinding

class UserInterestFragment : Fragment() {

    private lateinit var binding: FragmentUserInterestBinding
    private lateinit var appPreferences: AppPreferences

    private var isGenderSelected = false
    private var gender: String = ""

    private var level = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInterestBinding.inflate(layoutInflater)
        appPreferences = AppPreferences(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            goToNext()
        }

        binding.genderRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            isGenderSelected = true
            val radio: RadioButton = binding.root.findViewById(checkedId)
            gender = radio.text.toString()
        }
    }

    private fun goToNext() {
        getLevel()

        if (!isGenderSelected) {
            Toast.makeText(requireContext(), "Select gender", Toast.LENGTH_LONG).show()
            return
        }

        if (level == 0) {
            Toast.makeText(requireContext(), "Select at least one goals.", Toast.LENGTH_LONG)
                .show()
            return
        }

        appPreferences.saveGender(gender)
        appPreferences.saveLevel(level)
        findNavController().navigate(R.id.action_user_interest_to_plank_details)
    }

    private fun getLevel() {
        var tempLevel = 0

        with(binding) {
            if (checkBox1.isChecked)
                tempLevel += 1

            if (checkBox2.isChecked)
                tempLevel += 1

            if (checkBox3.isChecked)
                tempLevel += 1

            if (checkBox4.isChecked)
                tempLevel += 1

            if (checkBox5.isChecked)
                tempLevel += 1

            if (checkBox6.isChecked)
                tempLevel += 1
        }
        if (tempLevel == 0 || tempLevel == 1 || tempLevel == 2)
            level = 1
        else if (tempLevel == 3 || tempLevel == 4)
            level = 2

        if (tempLevel == 5 || tempLevel == 6)
            level = 3

    }


}