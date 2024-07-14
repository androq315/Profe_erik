package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val length: Double = 5.0
                    val width: Double? = 5.0

                    val area = calculateArea(length, width)
                    Greeting(area, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun calculateArea(length: Double, width: Double?): Double {
    val defaultWidth = 10.0 


    val finalWidth = width ?: defaultWidth

    return length * finalWidth
}

@Composable
fun Greeting(area: Double, modifier: Modifier = Modifier) {
    Text(text = "El área del rectángulo es: $area", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting(50.0) //
    }
}
