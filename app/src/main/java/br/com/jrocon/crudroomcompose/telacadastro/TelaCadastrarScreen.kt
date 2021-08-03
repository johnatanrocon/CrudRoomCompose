package br.com.jrocon.crudroomcompose.telacadastro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TelaCadastrarScreen(
    viewModel: TelaCadastrarViewModel = hiltViewModel(),
    navController: NavController
) {

    val nome = viewModel.nomeCidade.value
    val cep = viewModel.cepCidade.value
    val uf = viewModel.ufCidade.value

    val status = viewModel.status.observeAsState()

    if (status.value == true) {
        navController.popBackStack()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            label = { Text(text = "Informe o nome da cidade") },
            value = nome,
            onValueChange = {
                viewModel.onChangeNomeCidade(it)
            })
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            label = { Text(text = "Informe o cep da cidade") },
            value = cep,
            onValueChange = {
                viewModel.onChangeCepCidade(it)
            })
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            label = { Text(text = "Informe a uf da cidade") },
            value = uf,
            onValueChange = {
                viewModel.onChangeUfCidade(it)
            })
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {

            viewModel.Cadastrar()

        }) {
            Text(text = "Cadastrar")
        }
    }

}