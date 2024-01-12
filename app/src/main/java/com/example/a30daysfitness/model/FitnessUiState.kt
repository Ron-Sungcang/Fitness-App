package com.example.a30daysfitness.model

import com.example.a30daysfitness.model.ExcerciseRepository.starting

data class FitnessUiState (
    val currentDessertIndex: Int = 0,
    val currentProgram1A: List<Excercises> = listOf(),
    val currentProgram1B: List<Excercises> = listOf(),
    val currentProgram2A: List<Excercises> = listOf(),
    val currentProgram2B: List<Excercises> = listOf(),
    val currentProgram3A: List<Excercises> = listOf(),
    val currentProgram3B: List<Excercises> = listOf()
)