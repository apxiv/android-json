package com.fetchhiring.employeelist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fetchhiring.employeelist.models.Employee
import com.fetchhiring.employeelist.ui.theme.EmployeeListTheme
import com.fetchhiring.employeelist.viewmodel.EmployeeViewModel
import com.fetchhiring.employeelist.views.EmployeeItem

class MainActivity : ComponentActivity() {

    private val employeeViewModel by viewModels<EmployeeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeListTheme {
                Surface(color = MaterialTheme.colors.background) {
                    EmployeeList(employeeList = employeeViewModel.employeeListResponse)
                    employeeViewModel.getEmployeeList()
                }
            }
        }
    }
}

@Composable
fun EmployeeList(employeeList: List<Employee>) {
    LazyColumn {
        val newList = employeeList.filterNot { it.name.isNullOrEmpty() }.sortedWith(compareBy<Employee> { it.listId }.thenBy { it.name?.substringAfter("Item ")
            ?.toInt() })
        Log.d("list works?", "$employeeList")
        //Log.d("new list works?", "$newList")
        //val sortNewList = newList.sortedWith(compareBy<Employee> { it.listId }.thenBy { it.name?.substringAfter("Item ")?.toInt() })
        itemsIndexed(items = newList) { _, item ->
            EmployeeItem(employee = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmployeeListTheme {
        val employee = Employee(684, 4, "Item 504")
        EmployeeItem(employee = employee)
    }
}