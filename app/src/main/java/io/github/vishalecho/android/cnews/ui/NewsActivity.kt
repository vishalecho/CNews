package io.github.vishalecho.android.cnews.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.vishalecho.android.cnews.R
import io.github.vishalecho.android.cnews.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setUpToolbar()
        setContentView(binding.root)
    }

    private fun setUpToolbar() {
        binding.topAppbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.recent -> {
                    // Handle recent menu item press
                    Toast.makeText(this, "Recent", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popular -> {
                    // Handle popular menu item press
                    Toast.makeText(this, "Popular", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}