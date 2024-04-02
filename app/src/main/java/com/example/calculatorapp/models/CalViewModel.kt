package com.example.calculatorapp.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
    var number3 by mutableStateOf("")

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Operation1 -> enterOperation(action.symbol)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Percent -> performPercent()
        }
    }

    private fun performPercent() {
        if (state.operation == null && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = (state.number1.toDouble() * 0.01).toString()
            )
            return
        }
        if (state.number2.isNotBlank()) {
            state = state.copy(
                number2 = (state.number2.toDouble() * 0.01).toString()
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDouble()
        val number2 = state.number2.toDouble()
        val result = when (state.operation) {
            is CalculatorOperation.Add -> number1 + number2
            is CalculatorOperation.Multiply -> number1 * number2
            is CalculatorOperation.Subtract -> number1 - number2
            is CalculatorOperation.Divide -> number1 / number2
            else -> return
            }
            state = state.copy(
                number1 = if(result.toDouble() % 1 == 0.0) {
                    String.format("%.0f", result)
                } else {
                    String.format("%.9f", result)
                },
                number2 = "",
                operation = null
            )
            number3 = if(result.toDouble() % 1 == 0.0) {
                String.format("%.0f", result)
            } else {
                String.format("%.9f", result)
            }
    }


    private fun enterOperation(symbol: CalculatorOperation) {
        if(state.number1.isNotBlank()){
            state = state.copy(
                operation = symbol
            )
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") &&
            state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") &&
            state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation =  null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= 12) { return }
            state = state.copy(
                number1 = state.number1 + number,
                )
            return
        }
        if (state.number2.length >= 12) { return }
        state = state.copy(
            number2 = state.number2 + number,
        )
        return
    }
}
