package br.com.jrocon.crudroomcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.jrocon.crudroomcompose.data.dao.CidadeDao
import br.com.jrocon.crudroomcompose.data.entities.Cidades

@Database(entities = [Cidades::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {
    abstract fun cidadeDao(): CidadeDao
}