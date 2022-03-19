package com.example.testurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import com.example.testurrency.app.App
import com.example.testurrency.data.Money
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main), Listener {


    private var data: List<Money> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CurrencyFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        //навигация по фрагментам
        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CurrencyFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack("Currency").commit()
                    true
                }
                R.id.page_2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CalculateFragment.newInstance(data))
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack("Calculate").commit()
                    true
                }
                else -> false
            }
        }
    }

    override fun listener(value: List<Money>) {
        data = value
    }
}