package com.example.schoolsassigmentsergio.dataManager

import com.example.schoolsassigmentsergio.model.School
import com.example.schoolsassigmentsergio.model.SchoolDetail

interface AppRepository {
    suspend fun getSchoolsData(): List<School>
    suspend fun getSchoolsDetailsData(): List<SchoolDetail>
}
