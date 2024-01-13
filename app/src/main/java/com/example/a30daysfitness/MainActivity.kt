package com.example.a30daysfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysfitness.model.ExcerciseRepository
import com.example.a30daysfitness.ui.FitScreen
import com.example.a30daysfitness.ui.StartingStrenghtScreen
import com.example.a30daysfitness.ui.StartingStrengthLazyList
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysFitnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FitnessApp()
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    FitScreen()
}

@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    _30DaysFitnessTheme {
        FitScreen()
    }
}