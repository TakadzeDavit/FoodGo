package com.space.foodgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.space.core.ui.theme.FoodGoTheme
import com.space.foodgo.navigation.FoodGoContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodGoTheme {
                FoodGoContainer()
            }
        }
    }
}