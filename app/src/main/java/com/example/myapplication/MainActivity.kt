package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.Black
                ) {
                    Main(
                    )
                }
            }
        }
    }
}

@Composable
fun Main() {
    Column {
        Title("Title")
        OutlinedTextField(
            value = "",
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            onValueChange = {},
            singleLine = true,
            placeholder = { Text(text = "Enter Title", color = Color.Gray) }
        )
        Title("Status")
        Radio01()
        Title("Priority")
        Radio02()
        Title("Time and Date")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton("Choose Date")
            CustomButton("Choose Time")
        }
        Spacer(modifier = Modifier.padding(top = 124.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton("Cancel")
            CustomButton("Reset")
            CustomButton("Submit")
        }
    }
}

@Composable
fun Title(string: String) {
    Text(
        text = string,
        color = Color.White,
        fontSize = 24.sp,
        modifier = Modifier.padding(top = 20.dp)
    )
}

@Composable
fun CustomButton(string: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    ) {
        Text(string)
    }
}

@Composable
fun Radio01() {
    var selectedOption by remember { mutableStateOf("Not Done") }

    Row(verticalAlignment = Alignment.CenterVertically) {

        RadioButton(
            selected = selectedOption == "Done",
            onClick = { selectedOption = "Done" }
        )
        Text("Done", modifier = Modifier.padding(start = 8.dp), color = Color.White)

        RadioButton(
            selected = selectedOption == "Not Done",
            onClick = { selectedOption = "Not Done" }
        )
        Text("Not Done", modifier = Modifier.padding(start = 8.dp), color = Color.White)
    }
}

@Composable
fun Radio02() {
    var selectedOption by remember { mutableStateOf("Medium") }

    Row(verticalAlignment = Alignment.CenterVertically) {

        RadioButton(
            selected = selectedOption == "Low",
            onClick = { selectedOption = "Low" }
        )
        Text("Done", modifier = Modifier.padding(start = 8.dp), color = Color.White)

        RadioButton(
            selected = selectedOption == "Medium",
            onClick = { selectedOption = "Medium" }
        )
        Text("Not Done", modifier = Modifier.padding(start = 8.dp), color = Color.White)

        RadioButton(
            selected = selectedOption == "High",
            onClick = { selectedOption = "High" }
        )
        Text("Done", modifier = Modifier.padding(start = 8.dp), color = Color.White)
    }
}

