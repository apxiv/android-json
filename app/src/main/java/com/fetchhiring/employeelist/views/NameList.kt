package com.fetchhiring.employeelist.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fetchhiring.employeelist.models.Employee

@Composable
fun EmployeeItem(employee: Employee) {
    Box(modifier = Modifier.padding(10.dp)) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 6.dp,
            modifier = Modifier.requiredHeight(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                employee.name?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(2.0f)
                    )
                }
                Text(
                    text = employee.listId.toString(),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(4.dp)
                        .drawBehind {
                            drawCircle(
                                color = Color.Yellow,
                                radius = this.size.minDimension
                            )
                        }
                )
            }
        }
    }
}