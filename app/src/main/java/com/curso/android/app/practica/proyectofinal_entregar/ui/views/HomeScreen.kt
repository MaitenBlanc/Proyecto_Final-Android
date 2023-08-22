package com.curso.android.app.practica.proyectofinal_entregar.ui.views

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.curso.android.app.practica.proyectofinal_entregar.R
import com.curso.android.app.practica.proyectofinal_entregar.ui.theme.ProyectoFinalEntregarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val homeUiState by homeViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = homeUiState.palabra1,
            onValueChange = { homeViewModel.updatePalabra1(it) },
            label = { Text(text = stringResource(R.string.ingresar1)) }
        )
        TextField(value = homeUiState.palabra2,
            onValueChange = { homeViewModel.updatePalabra2(it) },
            label = { Text(text = stringResource(R.string.ingresar2)) }
        )
        Button(onClick = { homeViewModel.checkWords() }) {
            Text(text = stringResource(R.string.button_text))
        }
        if(homeUiState.isEqual) {
            val texto = stringResource(R.string.textSame)
            Text(text = texto)
        } else {
            val texto = stringResource(R.string.textNotSame)
            Text(text = texto)
        }
    }
}

@VisibleForTesting
internal fun compare(palabra1: String, palabra2: String, isEqual: Boolean): Boolean {
    val comparate = palabra1 == palabra2
    if (comparate == true) {
        return isEqual
    } else {
        return false
    }
}

@Preview(showSystemUi = true)
@Composable
fun PantallaHome() {
    ProyectoFinalEntregarTheme() {
        HomeScreen()
    }
}