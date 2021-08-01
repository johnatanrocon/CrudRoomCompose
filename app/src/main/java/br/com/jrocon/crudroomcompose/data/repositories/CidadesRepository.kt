package br.com.jrocon.crudroomcompose.data.repositories

import br.com.jrocon.crudroomcompose.data.database.AppDb
import br.com.jrocon.crudroomcompose.data.entities.Cidades
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class CidadesRepository @Inject constructor(appDb: AppDb) {


    private val dao = appDb.cidadeDao()

    val getAllCidades: Flow<List<Cidades>> = dao.getAllCidades()

    suspend fun addCidade(cidade: Cidades) {
        dao.insert(cidade)
    }

    suspend fun updateCidade(cidade: Cidades) {
        dao.update(cidade)
    }

    suspend fun removeCidade(cidade: Cidades) {
        dao.delete(cidade)
    }

}