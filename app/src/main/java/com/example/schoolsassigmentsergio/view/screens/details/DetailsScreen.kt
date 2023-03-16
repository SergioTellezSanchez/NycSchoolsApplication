package com.example.schoolsassigmentsergio.view.screens.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.schoolsassigmentsergio.view.AppState
import com.example.schoolsassigmentsergio.view.UiState
import com.example.schoolsassigmentsergio.view.screens.utils.ErrorScreen
import com.example.schoolsassigmentsergio.view.screens.utils.LoadingScreen

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    appState: AppState,
    uiState: State<UiState>,
    retryAction: () -> Unit,
) {
    when (appState) {
        is AppState.Loading -> LoadingScreen(modifier)
        is AppState.Success -> SchoolsDetailsListScreen(
            modifier = modifier,
            uiState = uiState
        )
        is AppState.Error -> ErrorScreen(modifier, retryAction)
    }

}

@Composable
fun SchoolsDetailsListScreen(
    modifier: Modifier,
    uiState: State<UiState>
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {}
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            uiState.value.selectedSchoolDetail?.let { selectedSchool ->
                DetailCard(
                    schoolDetailData = selectedSchool
                )
            }

        }
    }
}