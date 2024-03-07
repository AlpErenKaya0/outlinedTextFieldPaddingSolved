package com.alperen.testbg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFields()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TextFields() {
    val outlinedtext = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = outlinedtext.value,
            onValueChange = { outlinedtext.value = it },
            label = {
                Text(
                    text = "Label",
                    modifier = Modifier
                        .drawBehind {      drawRoundRect(
                            Color(0xFFBBAAEE),
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )  }

                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Blue,
                focusedLabelColor = Color.Red,
                unfocusedLabelColor = Color.White,
                textColor = Color.Yellow,
                containerColor = Color.Gray,
                cursorColor = Color.Red,
            ),
            modifier = Modifier.drawBehind {
                drawRoundRect(
                    Color.Gray,
                    cornerRadius = CornerRadius(0.dp.toPx()),
                    topLeft = Offset(40F,30F),
                    size = Size(140F, 150F)
                )
            }
                .padding(0.dp)
        )
            }

    }

