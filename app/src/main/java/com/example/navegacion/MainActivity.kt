package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.model.Routers
import com.example.navegacion.ui.theme.NavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Nav()
                }
            }
        }
    }
}

@Composable
fun Nav() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = "pantalla01"
    ) {
        composable(Routers.Pantalla01.route) { Screen01(navigationController = navigationController) }
        composable(Routers.Pantalla02.route) { Screen02(navigationController = navigationController) }
        composable(
            Routers.Pantalla03.route,
            arguments = listOf(navArgument("parametro") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            Screen03(
                navigationController = navigationController,
                parametro = backStackEntry.arguments?.getInt("parametro") ?: 0
            )
        }
        composable(
            Routers.Pantalla04.route,
            arguments = listOf(navArgument("parametroOpcional") {
                defaultValue = "Default"
            })
        ) { backStackEntry ->
            Screen04(
                navigationController = navigationController,
                parametroOpcional = backStackEntry.arguments?.getString("parametroOpcional")
            )
        }
    }
}