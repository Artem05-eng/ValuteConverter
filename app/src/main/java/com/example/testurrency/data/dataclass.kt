package com.example.testurrency.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class Wrapper<T>(
    val Valute: T
)

@Parcelize
@JsonClass(generateAdapter = true)
data class Valute(
    val AUD: Money,
    val AZN: Money,
    val GBP: Money,
    val AMD: Money,
    val BYN: Money,
    val BGN: Money,
    val BRL: Money,
    val HUF: Money,
    val HKD: Money,
    val DKK: Money,
    val USD: Money,
    val EUR: Money,
    val INR: Money,
    val KZT: Money,
    val CAD: Money,
    val KGS: Money,
    val CNY: Money,
    val MDL: Money,
    val NOK: Money,
    val PLN: Money,
    val RON: Money,
    val XDR: Money,
    val SGD: Money,
    val TJS: Money,
    val TRY: Money,
    val TMT: Money,
    val UZS: Money,
    val UAH: Money,
    val CZK: Money,
    val SEK: Money,
    val CHF: Money,
    val ZAR: Money,
    val KRW: Money,
    val JPY: Money
): Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "money")
data class Money(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val ID: String,
    @ColumnInfo(name = "char_code")
    val CharCode: String,
    @ColumnInfo(name = "name")
    val Name: String,
    @ColumnInfo(name = "value")
    val Value: Double
): Parcelable