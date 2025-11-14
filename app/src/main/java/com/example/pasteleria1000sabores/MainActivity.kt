package com.example.pasteleria1000sabores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pasteleria1000sabores.ui.theme.Pasteleria1000SaboresTheme
import com.example.pasteleria1000sabores.ui.theme.PantallaInicial

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pasteleria1000SaboresTheme {
                PantallaInicial()
            }
        }
    }
}
