package br.com.jrocon.crudroomcompose.data.dao

import androidx.room.*
import br.com.jrocon.crudroomcompose.data.entities.Cidades
import kotlinx.coroutines.flow.Flow

@Dao
interface CidadeDao {

    @Insert
    suspend fun insert(cidade: Cidades)

    @Update
    suspend fun update(cidade: Cidades)

    @Delete
    suspend fun delete(cidade: Cidades)

    @Query("select * from Cidades")
    fun getAllCidades(): Flow<List<Cidades>>


}