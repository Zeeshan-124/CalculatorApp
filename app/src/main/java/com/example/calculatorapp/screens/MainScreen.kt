package com.example.calculatorapp.screens

import androidx.collection.emptyLongSet
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Percent
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.components.Cal2Button
import com.example.calculatorapp.components.CalButton
import com.example.calculatorapp.models.CalculatorAction
import com.example.calculatorapp.models.CalculatorOperation
import com.example.calculatorapp.models.CalculatorState


@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    total: String = "",
    state: CalculatorState = CalculatorState(),
    onAction: (CalculatorAction) -> Unit = {}
) {
    var result by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .then(modifier),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = if (state.number1.isBlank()) {
                    "0"
                } else {
                    state.number1 + (state.operation?.symbol ?: "") + state.number2
                },
                textAlign = TextAlign.End,
                fontWeight = FontWeight.W400,
                fontSize = 50.sp,
                lineHeight = 60.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 6.dp)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(bottom = 50.dp, top = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "AC",
                        color = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Clear)
                        },
                        size = 24.sp
                    )
                    Cal2Button(
                        modifier = Modifier
                            .size(60.dp),
                        image = Icons.AutoMirrored.Outlined.Backspace,
                        color = Color(0xffff7433),
                        onClick = { onAction(CalculatorAction.Delete) },
                        size = 24.dp
                    )
                    Cal2Button(
                        modifier = Modifier
                            .size(60.dp),
                        image = Icons.Outlined.Percent,
                        color = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Percent)
                        },
                        size = 24.dp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "÷",
                        color = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Operation1(CalculatorOperation.Divide))
                        },
                        size = 30.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "7",
                        onClick = {
                            onAction(CalculatorAction.Number(7))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "8",
                        onClick = {
                            onAction(CalculatorAction.Number(8))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "9",
                        onClick = {
                            onAction(CalculatorAction.Number(9))
                        },
                        size = 24.sp
                    )
                    Cal2Button(
                        modifier = Modifier
                            .size(60.dp),
                        image = Icons.Outlined.Close,
                        color = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Operation1(CalculatorOperation.Multiply))
                        },
                        size = 24.dp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "4",
                        onClick = {
                            onAction(CalculatorAction.Number(4))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "5",
                        onClick = {
                            onAction(CalculatorAction.Number(5))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "6",
                        onClick = {
                            onAction(CalculatorAction.Number(6))
                        },
                        size = 24.sp
                    )
                    Cal2Button(
                        modifier = Modifier
                            .size(60.dp),
                        image = Icons.Outlined.Remove,
                        color = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Operation1(CalculatorOperation.Subtract))
                        },
                        size = 24.dp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "1",
                        onClick = {
                            onAction(CalculatorAction.Number(1))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "2",
                        onClick = {
                            onAction(CalculatorAction.Number(2))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "3",
                        onClick = {
                            onAction(CalculatorAction.Number(3))
                        },
                        size = 24.sp
                    )
                    Cal2Button(
                        modifier = Modifier
                            .size(60.dp),
                        image = Icons.Outlined.Add,
                        color = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Operation1(CalculatorOperation.Add))
                        },
                        size = 24.dp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(54.dp),
                ) {
                    CalButton(
                        modifier = Modifier
                            .size(60.dp)
                            .weight(0.1f),
                        number = "0",
                        onClick = {
                            onAction(CalculatorAction.Number(0))
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            //                    .padding(horizontal = 54.dp)
                            .size(60.dp),
                        number = ".",
                        onClick = {
                            onAction(CalculatorAction.Decimal)
                        },
                        size = 24.sp
                    )
                    CalButton(
                        modifier = Modifier
                            .size(60.dp),
                        number = "=",
                        color = Color.White,
                        background = Color(0xffff7433),
                        onClick = {
                            onAction(CalculatorAction.Calculate)
                        },
                        size = 24.sp
                    )
                }
            }
        }
    }
}
