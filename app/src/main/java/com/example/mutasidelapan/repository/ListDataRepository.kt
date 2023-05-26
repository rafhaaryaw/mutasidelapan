package com.example.mutasidelapan.repository

import com.example.mutasidelapan.data.InputDataModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ListDataRepository {

    private val data = Firebase.firestore.collection("DataMutasi")

    suspend fun getAllData(): List<InputDataModel> {
        return withContext(Dispatchers.IO) {
            return@withContext data.get().await().toObjects(InputDataModel::class.java)
        }
    }

    suspend fun getDetailData(mutasiDataId: String): InputDataModel {
        return withContext(Dispatchers.IO) {
            return@withContext data.document(mutasiDataId).get().await().toObject(InputDataModel::class.java)!!
        }
    }


}