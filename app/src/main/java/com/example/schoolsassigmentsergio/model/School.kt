package com.example.schoolsassigmentsergio.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class School(
    @SerialName("dbn")
    val id: String? = "",
    @SerialName("school_name")
    val schoolName: String,
    @SerialName("campus_name")
    val campusName: String? = null,
    @SerialName("neighborhood")
    val neighborhood: String,
    @SerialName("overview_paragraph")
    val overview: String,
    @SerialName("school_email")
    val schoolEmail: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("academicopportunities1")
    val academicOpportunities: String? = "",
)


@Serializable
data class SchoolDetail(
    @SerialName("dbn")
    val id: String? = "",
    @SerialName("num_of_sat_test_takers")
    val numOfSatTestTakers: String,
    @SerialName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String,
    @SerialName("sat_math_avg_score")
    val satMathAvgScore: String,
    @SerialName("sat_writing_avg_score")
    val satWritingAvgScore: String,
    @SerialName("school_name")
    val schoolName: String,
    var overview: String? = "",
)
