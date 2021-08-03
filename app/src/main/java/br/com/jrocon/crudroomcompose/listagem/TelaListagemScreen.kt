package br.com.jrocon.crudroomcompose.listagem

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.com.jrocon.crudroomcompose.data.entities.Cidades

@Composable
fun TelaListagemScreen(
    viewModel: TelaListagemViewModel = hiltViewModel(),
    navController: NavController
) {
    var cidades = viewModel.cidadesLista.observeAsState(listOf())

    LazyColumn() {
        itemsIndexed(items = cidades.value) { index, item ->
            meuCard(navController = navController, cidade = item)
        }
    }
}


@Composable
fun meuCard(navController: NavController, cidade: Cidades) {

    Card(elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .clickable {
                navController.currentBackStackEntry?.arguments = Bundle().apply {
                    putParcelable("cidade", cidade)
                }
                navController.navigate("telaExibir")
            }
    ) {
        Column() {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = cidade.nomeCidade.toString()
            )
        }

    }
}