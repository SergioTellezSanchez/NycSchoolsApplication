package com.example.schoolsassigmentsergio.view.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schoolsassigmentsergio.model.School
import com.example.schoolsassigmentsergio.R


@Composable
fun SchoolCard(
    schoolData: School,
    seeDetails: (School) -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = modifier.padding(20.dp)) {
            Column(
                modifier = modifier.weight(1f),
                Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.school_name, schoolData.schoolName),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                schoolData.campusName?.let {
                    Text(
                        text = stringResource(id = R.string.campus_name, schoolData.campusName),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                }
                Spacer(modifier = modifier.height(10.dp))
                schoolData.schoolEmail?.let { schoolEmail ->
                    Text(
                        text = stringResource(id = R.string.school_email, schoolEmail),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                }
                Text(
                    text = stringResource(id = R.string.neighborhood, schoolData.neighborhood),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                schoolData.phoneNumber?.let { phoneNumber ->
                    Text(
                        text = stringResource(id = R.string.phone_number, phoneNumber),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                }
                Button(onClick = { seeDetails(schoolData) }) {
                    Text(text = "Show details")
                }
            }
        }
    }
}

@Preview
@Composable
fun SchoolCardPreview() {
    SchoolCard(
        schoolData = School(
            schoolName = stringResource(id = R.string.test_school_name),
            neighborhood = stringResource(id = R.string.test_neighborhood),
            schoolEmail = stringResource(id = R.string.test_school_email),
            phoneNumber = stringResource(id = R.string.test_phone_number),
            campusName = stringResource(id = R.string.test_campus_name),
            id = stringResource(id = R.string.test_id),
            overview = stringResource(id = R.string.test_overview),
            academicOpportunities = stringResource(id = R.string.test_academic_opportunities),
        ),
        seeDetails = {},
        modifier = Modifier
    )
}