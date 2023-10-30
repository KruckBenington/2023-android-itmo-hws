package ru.ok.itmo.example

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class NavigationActivity : AppCompatActivity(R.layout.activity_navigation) {

    private lateinit var navigationView: NavigationBarView
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            commitFragment(R.string.fragment_a)
        }
        navigationView = findViewById(R.id.navigation_panel)
        navigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_a -> {
                    commitFragment(R.string.fragment_a)
                    return@setOnItemSelectedListener true
                }

                R.id.action_b -> {
                    commitFragment(R.string.fragment_b)
                    return@setOnItemSelectedListener true
                }

                R.id.action_c -> {
                    commitFragment(R.string.fragment_c)
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }


    }

    private fun commitFragment(label: Int) {
        val fragmentName = getString(label)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(
                R.id.fragment_to_update, SwitchFragment::class.java, bundleOf(
                    "label" to fragmentName
                )
            )
            addToBackStack(fragmentName)
        }
    }
}
