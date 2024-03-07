package com.example.adv160421148week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421148week2.databinding.FragmentCalculatorBinding
import com.example.adv160421148week2.databinding.FragmentGameBinding
import com.example.adv160421148week2.databinding.FragmentMainBinding

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private var score: Int = 0
    private var correctAnswer: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(
            inflater,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName =
                CalculatorFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }

        generateQuestion()

        binding.btnSubmit.setOnClickListener {
            val playerAnswer = binding.txtAnswer.text.toString().toIntOrNull()
            if (playerAnswer == correctAnswer) {
                score++
                generateQuestion()
                binding.txtAnswer.text?.clear()
            } else {
                val action = CalculatorFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
//        binding.btnStart.setOnClickListener {
//            val playerName = binding.txtName.text.toString()
//            val action = MainFragmentDirections.actionGameFragment(playerName)
//            Navigation.findNavController(it).navigate(action)
//        }
    }
    private fun generateQuestion() {
        val number1 = (0..100).random()
        val number2 = (0..100).random()
        correctAnswer = number1 + number2
        binding.txtQuestion.text = "$number1 + $number2 = ?"
    }

}