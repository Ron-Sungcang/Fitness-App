package com.example.a30daysfitness.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.FitnessUiState

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
        }
    }
}


@Preview
@Composable
private fun ThreeDayPreview(){}