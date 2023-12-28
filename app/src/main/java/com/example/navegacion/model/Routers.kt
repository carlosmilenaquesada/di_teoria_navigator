package com.example.navegacion.model

sealed class Routers(val route: String) {
    object Pantalla01 : Routers("pantalla01")
    object Pantalla02 : Routers("pantalla02")
    object Pantalla03 : Routers("pantalla03/{parametro}") {
        fun createRoute(parametro: Int) = "pantalla03/$parametro"
    }
    object Pantalla04 : Routers("pantalla04?parametroOpcional={parametroOpcional}"){
        fun createRoute(parametroOpcional : String) = "pantalla04?parametroOpcional=$parametroOpcional"
    }
}
