package com.example.modifierexpansion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.modifierexpansion.ui.extension.conditional


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
                Student("A", "20", true),
                Student("B", "20", false),
                Student("C", "20", true),
                Student("D", "20", true)
            )

            StudentCard(students)
        }
    }
}

@Composable
fun StudentCard(students: List<Student>){
    val context = LocalContext.current

    LazyColumn {
        items(students){ student ->
            Row (
                modifier = Modifier
                    .conditional(student.isChecked)
                    .ifTrue {
                        background(Color.Cyan)
                            .border(BorderStroke(0.dp, Color.Transparent))
                            .padding(30.dp)
                            .clickable {
                                Toast.makeText(context, "True", Toast.LENGTH_SHORT).show()
                            }
                    }
                    .ifFalse {
                        background(Color.Red.copy(alpha = .5f))
                            .border(BorderStroke(2.dp, Color.Black))
                            .padding(50.dp)
                            .clickable {
                                Toast.makeText(context, "False", Toast.LENGTH_SHORT).show()
                            }
                    }
            ){
                Text(
                    modifier = Modifier.weight(1f),
                    text = student.name
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = student.age
                )
            }
        }
    }
}