package com.example.testurrency

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testurrency.data.Money
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.valute_item.*

class ValuteAdapter: RecyclerView.Adapter<ValuteAdapter.ValuteHolder>() {

    private var list: List<Money> = emptyList()

    fun updateCityList(newList: List<Money>) {
        list = newList
    }

    class ValuteHolder(override val containerView: View?): RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bind(money: Money) {
            valuteName.text = money.Name.replace(" ", "\n", true)
            valuteValue.text = money.Value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
        return ValuteHolder(parent.inflate(R.layout.valute_item))
    }

    override fun onBindViewHolder(holder: ValuteHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}