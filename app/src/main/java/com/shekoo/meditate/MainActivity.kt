package com.shekoo.meditate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.shekoo.meditate.ui.NavigationScreen
import com.shekoo.meditate.ui.theme.MeditateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppRouter()// 👈 Call your navigation here
                  }
                }
            }
        }
    }