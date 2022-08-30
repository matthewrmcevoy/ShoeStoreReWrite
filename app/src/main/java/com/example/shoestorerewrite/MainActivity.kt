package com.example.shoestorerewrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import timber.log.Timber
import com.example.shoestorerewrite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var upNavigation = MutableLiveData<Boolean>()
    private lateinit var destinationTitle : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
       navController.addOnDestinationChangedListener{ nc: NavController, nd: NavDestination, args: Bundle? ->
            destinationTitle = nd.label.toString()
            if(nd.label == "fragment_shoe_list" || nd.label == "fragment_login"){
                upNavigation.value = false
            }else{
                upNavigation.value = true
            }
        }
        upNavigation.observe(this, Observer{
                nv -> if(nv == true){
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = destinationTitle
        }
        else{
            supportActionBar?.setDisplayShowHomeEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.title = destinationTitle
        }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}