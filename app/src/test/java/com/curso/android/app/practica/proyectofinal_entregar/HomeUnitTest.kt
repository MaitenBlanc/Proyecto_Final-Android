package com.curso.android.app.practica.proyectofinal_entregar

import com.curso.android.app.practica.proyectofinal_entregar.ui.views.HomeViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HomeUnitTest {
    @Test
    fun checkWords_isTrue() {
        val homeViewModel = HomeViewModel()

        homeViewModel.updatePalabra1(R.string.textPrueba1.toString())
        homeViewModel.updatePalabra2(R.string.textPrueba1.toString())
        assertFalse(homeViewModel.uiState.value.isEqual)
        homeViewModel.checkWords()
        assertTrue(homeViewModel.uiState.value.isEqual)
    }

    @Test
    fun checkWords_isFalse() {
        val homeViewModel = HomeViewModel()
        homeViewModel.updatePalabra1(R.string.textPrueba1.toString())
        homeViewModel.updatePalabra2(R.string.textPrueba2.toString())
        assertFalse(homeViewModel.uiState.value.isEqual)
        homeViewModel.checkWords()
        assertFalse(homeViewModel.uiState.value.isEqual)

    }
}