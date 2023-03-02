package com.example.schoolsassigmentsergio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.schoolsassigmentsergio.navigation.NavigationComponent
import com.example.schoolsassigmentsergio.view.AppState
import com.example.schoolsassigmentsergio.view.Screen
import com.example.schoolsassigmentsergio.view.UiState
import com.example.schoolsassigmentsergio.view.theme.SchoolsAssigmentSergioTheme
import com.example.schoolsassigmentsergio.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolsAssigmentSergioTheme {
                val appViewModel: AppViewModel =
                    viewModel(factory = AppViewModel.Factory)

                val appState: AppState = appViewModel.appState

                val uiState: State<UiState> = appViewModel.uiState

                val navController = rememberNavController()

                NavigationComponent(
                    appState = appState,
                    uiState = uiState,
                    navController = navController,
                    getSchoolsData = { appViewModel.getSchoolsData() },
                    seeDetails = { schoolSelected, schoolsDetails ->
                        appViewModel.updateSelectedSchool(schoolSelected, schoolsDetails)
                        navController.navigate(Screen.Details.toString())
                    },
                )

            }
        }
    }
}