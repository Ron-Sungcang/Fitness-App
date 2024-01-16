package com.example.a30daysfitness

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a30daysfitness.model.FitnessUiState
import com.example.a30daysfitness.model.Programs
import com.example.a30daysfitness.ui.theme.FitnessViewModel
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme
import androidx.navigation.compose.rememberNavController
import com.example.a30daysfitness.ui.JudoLazyList
import com.example.a30daysfitness.ui.StartingStrengthLazyList
import com.example.a30daysfitness.ui.ThreeDayLazyList


enum class FitnessScreen() {
    Start,
    Starting,
    Judo,
    ThreeDay
}


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {Text(stringResource(id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription =stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitScreen(
    viewModel: FitnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    val startingstring = stringResource(id = R.string.program1)
    val judostring = stringResource(id = R.string.program2)
    val threedaystring = stringResource(id = R.string.program3)
    Scaffold (
        topBar = {
            FitAppBar(
                canNavigateBack =  navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp()  }
            )
        }
    ){innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(navController = navController,
            startDestination = FitnessScreen.Start.name,
            modifier = Modifier.padding(innerPadding)){
            composable(route = FitnessScreen.Start.name){
                FitLazyList(uiState = uiState,viewModel,navController)
            }
            composable(route = startingstring){
                StartingStrengthLazyList(uiState = uiState)
            }
            composable(route = judostring){
                JudoLazyList(uiState = uiState)
            }
            composable(route = threedaystring){
                ThreeDayLazyList(uiState = uiState)
            }
        }
    }
}


@Composable
fun FitLazyList(
    uiState: FitnessUiState,
    viewModel: FitnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier)
{
    LazyColumn(modifier = modifier){
        items(uiState.currentPrograms){programs ->
            val string = stringResource(id = programs.nameRes)
            FitItem(
                programs = programs,
                onClick = {
                    viewModel.setupScreens(programs.nameRes)
                    navController.navigate(string)
                          },
                modifier = Modifier.padding(8.dp)
                )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitItem(
    programs: Programs,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
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