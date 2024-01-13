package com.example.a30daysfitness.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.ExcerciseRepository
import com.example.a30daysfitness.model.FitnessUiState
import com.example.a30daysfitness.model.Programs
import com.example.a30daysfitness.ui.theme.FitnessViewModel
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme
import javax.sql.DataSource

@Composable
fun FitScreen(
    viewModel: FitnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    val uiState by viewModel.uiState.collectAsState()
    FitLazyList(uiState = uiState)
}

@Composable
fun FitLazyList(
    uiState: FitnessUiState,
    modifier: Modifier = Modifier)
{
    LazyColumn(modifier = modifier){
        items(uiState.currentPrograms){programs ->
            FitItem(
                programs = programs,
                modifier = Modifier.padding(8.dp)
                )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitItem(programs: Programs, modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = {}
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text(
                text = LocalContext.current.getString(programs.nameRes),
                style = MaterialTheme.typography.displayLarge
                )
            Spacer(Modifier.width(16.dp))
            Box{
                Image(painter = painterResource(programs.imageRes),
                    contentDescription = LocalContext.current.getString(programs.nameRes),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = LocalContext.current.getString(programs.descriptionRes),
                style = MaterialTheme.typography.bodyLarge
                )
        }
    }
}

@Preview
@Composable
private fun FitPreview(){
    _30DaysFitnessTheme {
        FitScreen()
    }
}