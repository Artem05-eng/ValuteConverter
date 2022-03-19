package com.example.testurrency

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.testurrency.app.App
import com.example.testurrency.data.Money
import kotlinx.android.synthetic.main.calculate_fragment.*
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import javax.inject.Inject

class CalculateFragment : Fragment(R.layout.calculate_fragment) {

    @Inject
    lateinit var viewModel: MainViewModel

    companion object {
        const val DATA_KEY = "data_key"
        fun newInstance(data: List<Money>): CalculateFragment {
            return CalculateFragment().withArguments {
                putParcelableArray(DATA_KEY, data.toTypedArray())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as App).component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var money1: Money? = null
        var money2: Money? = null
        val args = (arguments?.getParcelableArray(DATA_KEY) as Array<Money>).toList()
        val names = args.map { it.CharCode }
        //создаем адаптеры для спиннеров
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, names)
        (spinner1.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (spinner2.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        //создаем слушатели для спиннеров
        (spinner1.editText as? AutoCompleteTextView)?.setOnItemClickListener { parent, view, position, id ->
            money1 = args[position]
        }
        (spinner2.editText as? AutoCompleteTextView)?.setOnItemClickListener { parent, view, position, id ->
            money2 = args[position]
        }

        //обработка нажатия кнопки
        calculate.setOnClickListener {
            try {
                val number = enterNumber.text.toString().toDouble()
                val res = ((number * money1!!.Value) / money2!!.Value)
                result.text = String.format("%.2f", res) + " " + "${money2!!.CharCode}"
            } catch (t: Throwable) {
                //в случае ошибки появляется всплывающее сообщение
                Log.e("Calculate", "${t.message}", t)
                Toast.makeText(requireContext(), "Ошибка ввода данных", Toast.LENGTH_SHORT).show()
            }
        }
    }
}