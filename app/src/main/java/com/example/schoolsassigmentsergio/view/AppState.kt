package com.example.schoolsassigmentsergio.view

import com.example.schoolsassigmentsergio.model.School
import com.example.schoolsassigmentsergio.model.SchoolDetail

sealed interface AppState {
    data class Success(
        val schools: List<School>,
        val schoolsDetails: List<SchoolDetail>
    ) : AppState

    object Error : AppState
    object Loading : AppState
}

data class UiState(
    val selectedSchoolDetail: SchoolDetail ? = null
)

enum class Screen {
    Main, Details
}

