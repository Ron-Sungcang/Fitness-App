package com.example.a30daysfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysfitness.model.ExcerciseRepository
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
    val exerciselist1a = remember {ExcerciseRepository.starting1a}
    val exerciselist1b = remember {ExcerciseRepository.starting1b}
    val exerciselist2a = remember {ExcerciseRepository.starting2a}
    val exerciselist2b = remember {ExcerciseRepository.starting2b}
    val exerciselist3a = remember {ExcerciseRepository.starting3a}
    val exerciselist3b = remember {ExcerciseRepository.starting3b}
    StartingStrengthLazyList(
        excerciselist1a = exerciselist1a,
        excerciselist1b = exerciselist1b,
        excerciselist2a = exerciselist2a,
        excerciselist2b = exerciselist2b,
        excerciselist3a = exerciselist3a,
        excerciselist3b = exerciselist3b
    )
}

@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    _30DaysFitnessTheme {
        FitnessApp()
    }
}