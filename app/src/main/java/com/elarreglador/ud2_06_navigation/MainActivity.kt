package com.elarreglador.ud2_06_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// Para que navController funcione se requiere de estas importaciones:
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// Y ademas:
// en /App/build.gradle.kts agregar esta linea en dependencies:
// implementation("androidx.navigation:navigation-compose:2.8.3")
// en /gradle/wrapper/lib.versions.toml agregar esta linea:
// androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version = "2.8.3" }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("detail") { DetailScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla de Inicio HomeScreen()")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("detail") }) {
            Text("Ir a Detalles")
        }
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla de Detalles")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("home") }
        ) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "Check!"
            )
            Text("navController.navigate(\"home\")")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Check!"
            )
            Text("navController.popBackStack()")
        }
    }
}

