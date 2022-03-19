package com.example.testurrency

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testurrency.app.App
import kotlinx.android.synthetic.main.currency_fragment.*
import javax.inject.Inject

class CurrencyFragment: Fragment(R.layout.currency_fragment) {

    @Inject
    lateinit var viewModel: MainViewModel
    private var valuteAdapter: ValuteAdapter? = null
    private val listener: Listener?
        get() = activity?.let { it as Listener }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as App).component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDataFromDB()
        viewModel.list.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                viewModel.getDataFromNetworkAndSaveToDB()
                viewModel.getDataFromDB()
            }
            valuteAdapter?.updateCityList(it)
            listener?.listener(it)
            valuteAdapter?.notifyDataSetChanged()
        }
        valuteAdapter = ValuteAdapter()
        with(valuteList) {
            adapter = valuteAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Нет подключения к Интернету", Toast.LENGTH_SHORT).show()
        }
        refresh.setOnClickListener {
            viewModel.getDataFromNetworkAndSaveToDB()
            viewModel.getDataFromDB()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        valuteAdapter = null
    }
}