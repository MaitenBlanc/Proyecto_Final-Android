package com.curso.android.app.practica.proyectofinal_entregar

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.proyectofinal_entregar.ui.views.HomeScreen

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_equals_words() {
        composeTestRule.setContent {
            HomeScreen()
        }

        composeTestRule.onNodeWithText("Ingrese palabra 1").performTextInput("Hola")
        composeTestRule.onNodeWithText("Ingrese palabra 2").performTextInput("Hola")
        composeTestRule.onNodeWithText("Comparar").performClick()
        composeTestRule.onNodeWithText("Son iguales").assertExists()
    }
}