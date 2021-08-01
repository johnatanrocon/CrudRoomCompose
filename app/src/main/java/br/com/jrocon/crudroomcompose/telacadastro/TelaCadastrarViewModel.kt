package br.com.jrocon.crudroomcompose.telacadastro

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jrocon.crudroomcompose.data.entities.Cidades
import br.com.jrocon.crudroomcompose.data.repositories.CidadesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TelaCadastrarViewModel @Inject constructor(private val dao: CidadesRepository) : ViewModel() {

    val nomeCidade = mutableStateOf("")
    val cepCidade = mutableStateOf("")
    val ufCidade = mutableStateOf("")


    fun onChangeNomeCidade(newValue: String) {
        nomeCidade.value = newValue
    }

    fun onChangeCepCidade(newValue: String) {
        cepCidade.value = newValue
    }

    fun onChangeUfCidade(newValue: String) {
        ufCidade.value = newValue
    }

    val status: MutableLiveData<Boolean> = MutableLiveData()

    fun Cadastrar() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.addCidade(
                    Cidades(
                        nomeCidade = nomeCidade.value,
                        cepCidade = cepCidade.value,
                        ufCidade = ufCidade.value
                    )
                )
                status.postValue(true)
            }
        }
    }


}