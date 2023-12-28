package com.example.navegacion

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.navegacion.model.Routers

@Composable
fun Screen01(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Screen01",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate("pantalla02")
                }
        )
    }
}

@Composable
fun Screen02(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Screen02",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routers.Pantalla03.createRoute(10))
                }
        )
    }
}

@Composable
fun Screen03(navigationController: NavHostController, parametro: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Column {
            Text(
                text = parametro.toString(),
                modifier = Modifier
                    .clickable {
                        navigationController.navigate(Routers.Pantalla04.createRoute("Hola"))
                    }
            )

            Text(
                text = parametro.toString(),
                modifier = Modifier
                    .clickable {
                        navigationController.navigate("pantalla04")
                    }
            )
        }
    }
}

@Composable
fun Screen04(navigationController: NavHostController, parametroOpcional: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = parametroOpcional.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.popBackStack()
                }
        )
    }
}