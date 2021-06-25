package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.MobileAds
import com.rsh_engineering.tkachenkoni.checkpressurelist.R
import com.rsh_engineering.tkachenkoni.checkpressurelist.billing.BillingAgentV2
import com.rsh_engineering.tkachenkoni.checkpressurelist.billing.BillingCallback
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BillingCallback {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    private var billingAgent: BillingAgentV2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Подключаем визуальный контроллер приложения
        navController = findNavController(this, R.id.navHostFragment)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainPersonFragment,
                R.id.pressureFragment,
                R.id.temperatureFragment,
                R.id.weightFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)


        billingAgent = BillingAgentV2(this, this)
        MobileAds.initialize(this)

        
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun removeAds() {
        billingAgent!!.purshaseView()
    }

    override fun onTokenConsumed() {
        navController.navigate(R.id.mainPersonFragment)
    }

    override fun onDestroy() {
        if (billingAgent != null) {
            billingAgent!!.onDestroy()
            billingAgent = null
        }
        super.onDestroy()
    }
}