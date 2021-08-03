package br.com.jrocon.crudroomcompose.listagem

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import br.com.jrocon.crudroomcompose.data.entities.Cidades
import br.com.jrocon.crudroomcompose.data.repositories.CidadesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TelaListagemViewModel @Inject constructor(private val dao: CidadesRepository) : ViewModel() {

    val cidadesLista: LiveData<List<Cidades>> = dao.getAllCidades.asLiveData()
}