package com.example.schoolsassigmentsergio.view.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.schoolsassigmentsergio.R
import com.example.schoolsassigmentsergio.model.SchoolDetail

@Composable
fun DetailCard(
    schoolDetailData: SchoolDetail,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxSize(),
        elevation = 4.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = modifier.padding(20.dp)) {
            Column(
                modifier = modifier.weight(1f),
                Arrangement.Center
            ) {
                Text(
                    text = schoolDetailData.schoolName,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = stringResource(
                        R.string.sat_math_avg_score,
                        schoolDetailData.satMathAvgScore
                    ),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = stringResource(
                        R.string.sat_critical_reading_avg_score,
                        schoolDetailData.satCriticalReadingAvgScore
                    ),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = stringResource(
                        R.string.sat_writing_avg_score,
                        schoolDetailData.satWritingAvgScore
                    ),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = stringResource(
                        R.string.num_of_sat_test_takers,
                        schoolDetailData.numOfSatTestTakers
                    ),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                schoolDetailData.overview?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable

fun DetailCardPreview() {
    DetailCard(
        schoolDetailData = SchoolDetail(
            id = stringResource(
                R.string.test_id
            ),
            schoolName = stringResource(
                R.string.test_school_name
            ),
            overview = stringResource(
                R.string.test_overview
            ),
            numOfSatTestTakers = stringResource(id = R.string.num_of_sat_test_takers),
            satCriticalReadingAvgScore = stringResource(id = R.string.sat_critical_reading_avg_score),
            satMathAvgScore = stringResource(id = R.string.sat_math_avg_score),
            satWritingAvgScore = stringResource(id = R.string.sat_writing_avg_score)
        ), modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
    )
}