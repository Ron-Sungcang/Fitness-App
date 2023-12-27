package com.example.a30daysfitness

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.a30daysfitness.model.ExcerciseRepository
import com.example.a30daysfitness.model.Excercises
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme

/**
 * A composable function that consists of a lazycolumn to display
 * everything in a scrollable fashion
 */
@Composable
fun StartingStrengthLazyList(
    excerciselist1a: List<Excercises>,
    excerciselist1b: List<Excercises>,
    excerciselist2a: List<Excercises>,
    excerciselist2b: List<Excercises>,
    excerciselist3a: List<Excercises>,
    excerciselist3b: List<Excercises>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        item {
            Text(
                text = stringResource(id = R.string.program1),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.programdesc1),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(id = R.string.phase1),
                style = MaterialTheme.typography.displayMedium
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.dayA),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(
            items = excerciselist1a,
            ){excercise ->
            val saveExer = remember{
                excercise
            }
            FitItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }


        item {
            Text(
                text = stringResource(id = R.string.dayB),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(excerciselist1b){excercise ->
            val saveExer = remember{
                excercise
            }
            FitItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.phase2),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(id = R.string.dayA),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        items(excerciselist2a){excercise ->
            val saveExer = remember{
                excercise
            }
            FitItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.dayB),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(excerciselist2b){excercise ->
            val saveExer = remember {
                excercise
            }
            FitItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.phase3),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(id = R.string.dayA),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        items(excerciselist3a){excercise ->
            val saveExer = remember{
                excercise
            }
            FitItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.dayB),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(excerciselist3b){excercise ->
            val saveExer = remember{
                excercise
            }
            FitItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}




/**
 * A composable function that is responsible for cards that display
 * each individual workout
 */
@Composable
fun FitItem(excercise: Excercises, modifier: Modifier = Modifier) {
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
            Box {
                Image(
                    painter = painterResource(excercise.imageRes),
                    contentDescription = LocalContext.current.getString(excercise.nameRes),
                    modifier = Modifier
                        .size(72.dp)
                        .clip(MaterialTheme.shapes.small)
                )

            }
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
                if (expanded) {
                    FitDesc(
                        excerciseDesc = excercise.descriptionRes,
                        excerciseImg = excercise.imageRes
                    )
                }
            }
            FitItemButton(expanded = expanded, onClick = { expanded = !expanded })
        }
    }
}

/**
 * Composable function for when the FitItem gets expanded
 */
@Composable
fun FitDesc(
    @StringRes excerciseDesc: Int,
    @DrawableRes excerciseImg: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = excerciseImg),
            contentDescription = stringResource(id = R.string.squat)
        )
        Text(
            text = stringResource(id = excerciseDesc),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * A composable function that has an IconButton that has the functionality of an expandable button
 */
@Composable
private fun FitItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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
private fun FitPreview() {
    _30DaysFitnessTheme {
        StartingStrengthLazyList(
            excerciselist1a = ExcerciseRepository.starting1a,
            excerciselist1b = ExcerciseRepository.starting1b,
            excerciselist2a = ExcerciseRepository.starting2a,
            excerciselist2b = ExcerciseRepository.starting2b,
            excerciselist3a = ExcerciseRepository.starting3a,
            excerciselist3b = ExcerciseRepository.starting3b
        )
    }
}
