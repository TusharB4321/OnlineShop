package com.example.onlineshop.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentOnBoardingBinding

class onBoardingFragment : Fragment() {

    private lateinit var binding:FragmentOnBoardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=ViewPagerAdapter(requireActivity())

        with(binding){
           vpOnBoarding.adapter=adapter
            wormDotsIndicator.attachTo(vpOnBoarding)

            vpOnBoarding.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    when(position){
                        0->{
                            tvSkip.setOnClickListener {
                                findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
                            }

                            tvPrevious.visibility=View.GONE
                            tvNext.setOnClickListener {
                                vpOnBoarding.currentItem=+1
                            }
                        }
                        1->{

                            tvSkip.setOnClickListener {
                                findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
                            }

                            tvNext.text="Next"
                            tvSkip.visibility=View.VISIBLE

                            tvPrevious.setOnClickListener {
                                vpOnBoarding.currentItem=-1
                            }
                            tvNext.setOnClickListener {
                                vpOnBoarding.currentItem=vpOnBoarding.currentItem+1
                            }
                        }else->{

                            tvSkip.visibility=View.GONE
                            tvNext.text="Finish"
                            tvPrevious.setOnClickListener {
                                vpOnBoarding.currentItem=vpOnBoarding.currentItem-1
                            }

                           tvNext.setOnClickListener {
                               findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
                               vpOnBoarding.currentItem=vpOnBoarding.currentItem+1
                           }

                        }

                    }
                }
            })
        }
    }

}