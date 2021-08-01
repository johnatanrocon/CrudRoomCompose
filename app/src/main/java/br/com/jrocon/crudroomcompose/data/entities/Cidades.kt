package br.com.jrocon.crudroomcompose.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "cidades")
@Parcelize
data class Cidades(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var nomeCidade: String? = null,
    var cepCidade: String? = null,
    var ufCidade: String? = null
) : Parcelable
