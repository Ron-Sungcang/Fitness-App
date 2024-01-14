package com.example.a30daysfitness.model

import com.example.a30daysfitness.R

object ExcerciseRepository {
    val programs = listOf(
        Programs(
            nameRes = R.string.program1,
            descriptionRes = R.string.program1desc,
            imageRes = R.drawable.starting_strength
        ),
        Programs(
            nameRes = R.string.program2,
            descriptionRes = R.string.program2desc,
            imageRes = R.drawable.judo_begin
        ),
        Programs(
            nameRes = R.string.program3,
            descriptionRes = R.string.program3desc,
            imageRes = R.drawable._day
        )
    )
    val excercises = listOf(
        Excercises(
            nameRes = R.string.squat,
            descriptionRes = R.string.squatdesc,
            imageRes = R.drawable._2560px_squats_svg,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.bench,
            descriptionRes = R.string.benchdesc,
            imageRes = R.drawable.bench_press_1_svg,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.deadlift,
            descriptionRes = R.string.deadliftdesc,
            imageRes = R.drawable._1200px_rear_deltoid_row_barbell_1_svg,
            reps = 5,
            sets = 1
        ),
        Excercises(
            nameRes = R.string.shoulderp,
            descriptionRes = R.string.shoulderpdesc,
            imageRes = R.drawable._4580253_200,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.clean,
            descriptionRes = R.string.cleandesc,
            imageRes = R.drawable._2227543,
            reps = 3,
            sets = 5
        ),

        Excercises(
            nameRes = R.string.deadclean,
            descriptionRes = R.string.deadcleandesc,
            imageRes = R.drawable._2227543,
            reps = 5,
            sets= 1
        ),

        Excercises(
            nameRes = R.string.chinup,
            descriptionRes = R.string.chinupdesc,
            imageRes = R.drawable.download,
            reps = 0,
            sets = 0
        ),
        Excercises(
            nameRes = R.string.dowelhinge,
            descriptionRes = R.string.dowelhingedesc,
            imageRes = R.drawable.dowel_hip_hinge,
            reps = 4,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.deadliftjump,
            descriptionRes = R.string.deadliftjumpdesc,
            imageRes = R.drawable._1200px_rear_deltoid_row_barbell_1_svg,
            reps = 4,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.lungeRow,
            descriptionRes = R.string.lungeRowDesc,
            imageRes = R.drawable.lungerow,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.zombiesquat,
            descriptionRes = R.string.zombiesquatdesc,
            imageRes = R.drawable.zombiesquat,
            reps = 6,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.armpulltowaist,
            descriptionRes = R.string.armpulltowaistdesc,
            imageRes = R.drawable.hingebackpulldown,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.shoulderpfromknee,
            descriptionRes = R.string.shoulderpfromkneedesc,
            imageRes = R.drawable.full_kneeling_dumbbell_overhead_press,
            reps = 8,
            sets = 3
        )
    )
}