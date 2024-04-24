package com.example.pejiadsmobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=AnaFragment()
        val secondFragment=HomeFragment()
        val thirdFragment=UserFragment()


        setCurrentFragment(secondFragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {item ->

            when(item.itemId){
                R.id.analytics->setCurrentFragment(firstFragment)
                R.id.home->setCurrentFragment(secondFragment)
                R.id.user->setCurrentFragment(thirdFragment)

            }

            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}