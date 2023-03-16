package com.example.schoolsassigmentsergio.dataManager.network

import com.example.schoolsassigmentsergio.dataManager.AppRepository
import com.example.schoolsassigmentsergio.model.School
import com.example.schoolsassigmentsergio.model.SchoolDetail

class NetworkAppRepository(
    private val appApiService: AppApiService
): AppRepository {

    override suspend fun getSchoolsData(): ArrayList<School> = appApiService.getSchoolsData()
    override suspend fun getSchoolsDetailsData(): ArrayList<SchoolDetail> = appApiService.getSchoolsDetailsData()
}