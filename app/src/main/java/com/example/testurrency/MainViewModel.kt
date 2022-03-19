package com.example.testurrency

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testurrency.data.Money
import com.example.testurrency.data.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repo): ViewModel() {

    private val mutableList = MutableLiveData<List<Money>>()
    private val mutableError = SingleLiveEvent<Throwable?>()

    val list : LiveData<List<Money>>
        get() = mutableList

    val error: LiveData<Throwable?>
        get() = mutableError

    fun getDataFromNetworkAndSaveToDB() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = withContext(Dispatchers.IO) {
                    repository.getValuteFromNetwork()
                }
                repository.saveValuteToDB(data)
            } catch (t: Throwable) {
                Log.e("network", "${t.message}", t)
                mutableError.postValue(t)
            }
        }
    }

    fun getDataFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = withContext(Dispatchers.IO) {
                repository.getValuteFromDB()
            }
            mutableList.postValue(result)
        }
    }

}