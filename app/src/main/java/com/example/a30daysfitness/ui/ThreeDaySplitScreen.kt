package com.example.a30daysfitness.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.FitnessUiState
import com.example.a30daysfitness.ui.components.ExerciseItem
import com.example.a30daysfitness.ui.theme.FitnessViewModel

@Composable
fun ThreeDayScreen(
    viewModel: FitnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    val uiState by viewModel.uiState.collectAsState()
    ThreeDayLazyList(uiState = uiState)

}

@Composable
fun ThreeDayLazyList(
    uiState: FitnessUiState,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier){
        item {
            Text(
                text = stringResource(id = R.string.program3),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.programdesc3),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(id = R.string.push),
                style = MaterialTheme.typography.displayMedium
            )
        }
        items(
            items = uiState.currentProgram1A,
        ){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.pull),
                style = MaterialTheme.typography.displayMedium
                )
        }
        items(
            items = uiState.currentProgram2A,
        ){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.legs),
                style = MaterialTheme.typography.displayMedium
            )
        }
        items(
            items = uiState.currentProgram3A,
        ){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}


@Preview
@Composable
private fun ThreeDayPreview(){}