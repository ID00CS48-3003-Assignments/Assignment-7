package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")

    var bmi: Double by mutableDoubleStateOf(0.0)
        private set

    fun onHeightChange(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
        calculateBmi()
    }

    fun onWeightChange(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toIntOrNull() ?: 0

        bmi = if (weight > 0 && height > 0) (weight / (height * height)).toDouble() else 0.0
    }
}