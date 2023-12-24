package com.example.a30daysfitness

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.model.Excercises
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme

class StartingStrengthScreen {

    /**
     * A composable function that is responsible for cards that display
     * each individual workout
     */
    @Composable
    fun FitItem(excercise: Excercises, modifier: Modifier = Modifier){
        Card(
            modifier = modifier,
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)) {
                Box{
                    Image(
                        painter = painterResource(excercise.imageRes),
                        contentDescription = LocalContext.current.getString(excercise.nameRes),
                        modifier = Modifier
                            .size(72.dp)
                            .clip(MaterialTheme.shapes.small)
                    )

                }
                Spacer(Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)){
                    Text(
                        text = LocalContext.current.getString(excercise.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = "Reps: " + excercise.reps.toString() + "Sets: " + excercise.sets.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
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
        modifier: Modifier = Modifier)
    {
        Column(modifier = modifier){
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

    @Preview
    @Composable
    private fun FitPreview(){
        _30DaysFitnessTheme {
        }
    }
}