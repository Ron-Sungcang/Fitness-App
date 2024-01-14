package com.example.a30daysfitness.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.Excercises
import com.example.a30daysfitness.model.FitnessUiState
import com.example.a30daysfitness.ui.theme.FitnessViewModel
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme

@Composable
fun JudoBeginnerScreen(
    viewModel: FitnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    val uiState by viewModel.uiState.collectAsState()
    JudoLazyList(uiState = uiState)

}
@Composable
fun JudoLazyList(
    uiState: FitnessUiState,
    modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        item {
            Text(
                text = stringResource(id = R.string.program2),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.programdesc2),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(id = R.string.phase1),
                style = MaterialTheme.typography.displayMedium
            )
        }
        items(
            items = uiState.currentProgram1A,
        ){excercise ->
            val saveExer = remember{
                excercise
            }
            JudoItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.onemin),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.phase2),
                style = MaterialTheme.typography.displayMedium
            )
        }
        items(
            items = uiState.currentProgram2A,
        ){excercise ->
            val saveExer = remember{
                excercise
            }
            JudoItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.onemin),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.phase3),
                style = MaterialTheme.typography.displayMedium
            )
        }
        items(
            items = uiState.currentProgram3A,
        ){excercise ->
            val saveExer = remember{
                excercise
            }
            JudoItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun JudoItem(
    excercise: Excercises,
    modifier: Modifier = Modifier
){
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Image(
                painter = painterResource(excercise.imageRes),
                contentDescription = LocalContext.current.getString(excercise.nameRes),
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            
            Spacer(Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = LocalContext.current.getString(excercise.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "Reps: " + excercise.reps.toString() + " " + "Sets: " + excercise.sets.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
                if(expanded){
                    JudoDesc(
                        excerciseDesc = excercise.descriptionRes,
                        excerciseImg = excercise.imageRes
                    )
                }
            }
            JudoButton(expanded = expanded, onClick = { expanded = !expanded })
        }
    }
}

@Composable
fun JudoDesc(
    @StringRes excerciseDesc: Int,
    @DrawableRes excerciseImg: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = excerciseImg),
            contentDescription = stringResource(id = excerciseDesc)
        )
        Text(
            text = stringResource(id = excerciseDesc),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun JudoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
private fun JudoBeginnerScreen(){
    _30DaysFitnessTheme {

    }
}