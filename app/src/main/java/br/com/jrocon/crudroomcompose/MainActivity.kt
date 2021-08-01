package br.com.jrocon.crudroomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.jrocon.crudroomcompose.ui.theme.CrudRoomComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudRoomComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val navController: NavHostController = rememberNavController()

                    NavHost(navController = navController, startDestination = "telaInicial") {
                        composable("telaInicial") { TelaInicial(navController) }
                    }

                }
            }
        }
    }
}

@Composable
fun TelaInicial(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "APP CRUD") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("telaCadastrar")
            }) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            Column() {

            }
        })
}