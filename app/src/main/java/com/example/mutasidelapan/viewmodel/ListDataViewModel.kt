package com.example.mutasidelapan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mutasidelapan.data.InputDataModel
import com.example.mutasidelapan.repository.ListDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListDataViewModel: ViewModel() {

    private var repository: ListDataRepository = ListDataRepository()

    fun getAllData(callback: (List<InputDataModel>) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = repository.getAllData()
            callback(result)
        }
    }

    fun getDetailDataMutasi(mutasiDataId: String, callback: (InputDataModel) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = repository.getDetailData(mutasiDataId)
            callback(result)
        }
    }

}

