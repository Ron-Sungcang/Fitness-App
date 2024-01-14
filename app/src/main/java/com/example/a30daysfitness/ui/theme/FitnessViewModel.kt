package com.example.a30daysfitness.ui.theme

import androidx.lifecycle.ViewModel
import com.example.a30daysfitness.model.ExcerciseRepository.programs
import com.example.a30daysfitness.model.Excercises
import com.example.a30daysfitness.model.FitnessUiState
import com.example.a30daysfitness.model.Programs

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FitnessViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(FitnessUiState(
        currentPrograms = programs,
        //currentProgram1A = make_workout_lis(starting, 0,1,2),
        //currentProgram1B = make_workout_lis(starting, 0,3,2),
       // currentProgram2A = make_workout_lis(starting, 0,1,2),
       // currentProgram2B = make_workout_lis(starting, 0,3,4),
       // currentProgram3A = make_workout_lis(starting, 0,1,5),
       // currentProgram3B = make_workout_lis(starting,0,3,6)
        )
    )
    val uiState: StateFlow<FitnessUiState> = _uiState.asStateFlow()


    private fun make_workout_lis(program: List<Excercises>,index1: Int, index2: Int, index3:Int): List<Excercises>{
        return listOf(program[index1], program[index2], program[index3])
    }
}