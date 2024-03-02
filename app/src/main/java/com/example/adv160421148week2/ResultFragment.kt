package com.example.adv160421148week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421148week2.databinding.FragmentMainBinding
import com.example.adv160421148week2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val score = ResultFragmentArgs.fromBundle(requireArguments()).score
        binding.txtScore.text = "Your score: $score"

        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}