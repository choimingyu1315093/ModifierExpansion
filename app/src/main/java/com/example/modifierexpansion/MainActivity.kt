package com.example.modifierexpansion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifierexpansion.ui.theme.ModifierExpansionTheme

data class Student(
    val name: String,
    val age: String,
    val isChecked: Boolean
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val students = listOf(
                Student("김학생", "20", true),
                Student("박학생", "21", false),
                Student("이학생", "22", true),
                Student("최학생", "23", true)
            )

            StudentCard(students = students)
        }
    }
}

@Composable
fun StudentCard(students: List<Student>){
    LazyColumn {
        items(students){ student ->
            Row (
                modifier = Modifier
                    .background(
                        if(student.isChecked){
                            Color.Cyan
                        }else {
                            Color.Red.copy(alpha = 0.5f)
                        }
                    )
                    .border(
                        if(student.isChecked){
                            BorderStroke(0.dp, Color.Transparent)
                        }else {
                            BorderStroke(2.dp, Color.Black)
                        }
                    )
                    .padding(30.dp)
            ){
                Text(
                    modifier = Modifier.weight(1f),
                    text = student.name,
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = student.age
                )
            }
        }
    }
}

