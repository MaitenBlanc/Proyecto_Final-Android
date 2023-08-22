package com.curso.android.app.practica.proyectofinal_entregar.ui.views

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun updatePalabra1(p1: String){
        _uiState.update {currentState ->
            currentState.copy(
                palabra1 = p1
            )
        }
    }

    fun updatePalabra2(p2: String){
        _uiState.update {currentState ->
            currentState.copy(
                palabra2 = p2
            )
        }
    }

    fun checkWords() {
        _uiState.update {currentState ->
            currentState.copy(
                isEqual = _uiState.value.palabra1 == _uiState.value.palabra2
            )
        }
    }
}