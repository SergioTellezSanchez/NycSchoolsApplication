package com.example.schoolsassigmentsergio.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.schoolsassigmentsergio.NycSchoolsApplication
import com.example.schoolsassigmentsergio.dataManager.AppRepository
import com.example.schoolsassigmentsergio.model.School
import com.example.schoolsassigmentsergio.model.SchoolDetail
import com.example.schoolsassigmentsergio.view.AppState
import com.example.schoolsassigmentsergio.view.UiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AppViewModel(
    private val appRepository: AppRepository
) : ViewModel() {

    var appState: AppState by mutableStateOf(AppState.Loading)
        private set

    private var _uiState = mutableStateOf(UiState())

    val uiState: State<UiState> = _uiState


    init {
        getSchoolsData()
    }

    fun updateSelectedSchool(
        schoolSelected: School,
        schoolsDetails: List<SchoolDetail>
    ) {

        val schoolDetailsSelected =
            schoolsDetails.first { it.id == schoolSelected.id }

        schoolDetailsSelected.overview = schoolSelected.overview

        _uiState.value = UiState(
            selectedSchoolDetail = schoolDetailsSelected
        )
    }

    fun getSchoolsData() {
        viewModelScope.launch {
            appState = AppState.Loading
            appState = try {

                val schoolsDetailsData = appRepository.getSchoolsDetailsData()
                val schoolsData = appRepository.getSchoolsData().filter { it.id != null }
                fun availableDetailsSchools(): List<School> {
                    val list: MutableList<School> = mutableListOf()

                    schoolsDetailsData.forEach { schoolDetailData ->
                        schoolsData.forEach { schoolData ->
                            if(schoolDetailData.id == schoolData.id) list.add(schoolData)
                        }
                    }

                    return list
                }

                AppState.Success(
                    availableDetailsSchools(),
                    schoolsDetailsData
                )
            } catch (e: IOException) {
                AppState.Error
            } catch (e: HttpException) {
                AppState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NycSchoolsApplication)
                val appRepository = application.container.appRepository
                AppViewModel(appRepository = appRepository)
            }
        }
    }
}