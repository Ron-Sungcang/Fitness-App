package com.example.a30daysfitness.model

data class FitnessUiState (
    val currentDessertIndex: Int = 0,
    val currentPrograms: List<Programs> = listOf(),
    val currentProgram1A: List<Excercises> = listOf(),
    val currentProgram1B: List<Excercises> = listOf(),
    val currentProgram2A: List<Excercises> = listOf(),
    val currentProgram2B: List<Excercises> = listOf(),
    val currentProgram3A: List<Excercises> = listOf(),
    val currentProgram3B: List<Excercises> = listOf()
)