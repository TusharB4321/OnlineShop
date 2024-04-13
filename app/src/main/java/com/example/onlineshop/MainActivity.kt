package com.example.onlineshop
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHandle()
    }

    private fun navHandle() {
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController=navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController)

        navHostFragment.navController.addOnDestinationChangedListener{_,destination,_->
            run {
                when (destination.id) {
                    R.id.splashFragment,
                    R.id.onBoardingFragment,
                    R.id.loginFragment,
                    R.id.registerFragment,
                    -> {
                        binding.bottomNavigationView.visibility = View.GONE
                    }
                    else -> {
                        binding.bottomNavigationView.visibility=View.VISIBLE
                    }

                }
            }
        }
    }
}