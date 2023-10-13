package ru.ok.itmo.example

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity(R.layout.activity_navigation) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = findViewById<TextView>(R.id.tv_fragment)
        val navView = findViewById<BottomNavigationView>(R.id.navigation_panel)
        val fragmentManager = supportFragmentManager
        fragmentManager.commit {
            setReorderingAllowed(true)
            add(SwitchFragment(), "fragment_a")
            addToBackStack("fragment_a")
            add(SwitchFragment(), "fragment_b")
            addToBackStack("fragment_b")
        }



    }
}