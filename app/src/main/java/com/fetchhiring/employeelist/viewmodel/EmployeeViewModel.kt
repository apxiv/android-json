package com.fetchhiring.employeelist.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetchhiring.employeelist.models.Employee
import com.fetchhiring.employeelist.network.ApiService
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {
    //mutable state of observable to notify the changes to composable at runtime
    var employeeListResponse: List<Employee> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")

    fun getEmployeeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val employeeList = apiService.getEmployees()
                employeeListResponse = employeeList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}