package com.example.testurrency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.testurrency.data.Money
import com.example.testurrency.data.Valute

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun <T : Fragment> T.withArguments(action: Bundle.() -> Unit): T {
    return apply {
        val args = Bundle().apply(action)
        arguments = args
    }
}

fun valuteToList(valute: Valute): List<Money> {
    return listOf(
        valute.AMD,
        valute.AUD,
        valute.AZN,
        valute.BGN,
        valute.BRL,
        valute.BYN,
        valute.CAD,
        valute.CHF,
        valute.CNY,
        valute.CZK,
        valute.DKK,
        valute.EUR,
        valute.GBP,
        valute.HKD,
        valute.HUF,
        valute.INR,
        valute.JPY,
        valute.KGS,
        valute.KRW,
        valute.KZT,
        valute.MDL,
        valute.NOK,
        valute.PLN,
        valute.RON,
        valute.SEK,
        valute.SGD,
        valute.TJS,
        valute.TMT,
        valute.TRY,
        valute.UAH,
        valute.USD,
        valute.UZS,
        valute.XDR,
        valute.ZAR
    )
}