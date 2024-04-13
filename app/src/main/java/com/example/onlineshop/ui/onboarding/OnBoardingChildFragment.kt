package com.example.onlineshop.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentOnBoardingChildBinding


class OnBoardingChildFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingChildBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentOnBoardingChildBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            binding.animationView.setAnimation(it!!.getInt(ANIME_PATH,R.raw.orangeonlineshooping))

        }
    }

    companion object{
        private const val ANIME_PATH="Anime"

       @JvmStatic
       fun newInstance(animPath: Int) =
           OnBoardingChildFragment().apply {
               arguments = Bundle().apply {
                   putInt(ANIME_PATH, animPath)
               }
           }

    }

}