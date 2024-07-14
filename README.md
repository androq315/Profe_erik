# MyApplication

Esta es una aplicación de ejemplo de Android utilizando Jetpack Compose que calcula y muestra el área de un rectángulo con una dimensión opcional.

## Descripción

La aplicación calcula el área de un rectángulo utilizando una longitud fija y un ancho opcional. Si el ancho no se proporciona, se utiliza un valor predeterminado. El resultado se muestra en la pantalla principal de la aplicación.

## Estructura del Proyecto



## Código Principal

### MainActivity.kt

```kotlin
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
                    val width: Double? = null

                    val area = calculateArea(length, width)
                    Greeting(area, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun calculateArea(length: Double, width: Double?): Double {
    val defaultWidth = 10.0 // Valor predeterminado para el ancho

    // Usar el operador Elvis para proporcionar un valor predeterminado si el ancho es nulo
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
        Greeting(50.0) 
    }
}



