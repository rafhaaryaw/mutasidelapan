package com.example.mutasidelapan.repository

import android.net.Uri
import com.example.mutasidelapan.data.InputDataModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.util.*

class InputDataRepository {

    private val data = Firebase.firestore.collection("DataMutasi")
    private val picture = Firebase.storage.getReference("FotoSiswa")

    suspend fun insertData(
        nama: String,
        kelas: String,
        nisn: String,
        nik: String,
        tempatTanggalLahir: String,
        alamat: String,
        mutasiDariSekolah: String,
        mutasiKeSekolah: String,
        mutasiDariKelas: String,
        mutasiKeKelas: String,
        mutasiDariJurusan: String,
        mutasiKeJurusan: String,
        tanggalMutasi: String,
        keteranganMutasi: String,
        fotoSiswa: Uri,
        namaAyah: String,
        alamatAyah: String,
        pekerjaanAyah: String,
        namaIbu: String,
        alamatIbu: String,
        pekerjaanIbu: String
    ) {
        withContext(Dispatchers.IO) {
            val idMutasiSiswa = UUID.randomUUID().toString()
            val imageUploadResult = picture.child(idMutasiSiswa).putFile(fotoSiswa).await()
            val imageUrl = imageUploadResult.metadata?.reference?.downloadUrl?.await().toString()
            val insertData = InputDataModel(
                id = idMutasiSiswa,
                nama = nama,
                kelas = kelas,
                nisn = nisn,
                nik = nik,
                tempatTanggalLahir = tempatTanggalLahir,
                alamat = alamat,
                mutasiDariSekolah = mutasiDariSekolah,
                mutasiKeSekolah = mutasiKeSekolah,
                mutasiDariKelas = mutasiDariKelas,
                mutasiKeKelas = mutasiKeKelas,
                mutasiDariJurusan = mutasiDariJurusan,
                mutasiKeJurusan = mutasiKeJurusan,
                tanggalMutasi = tanggalMutasi,
                keteranganMutasi = keteranganMutasi,
                fotoSiswaUrl = imageUrl,
                namaAyah = namaAyah,
                alamatAyah = alamatAyah,
                pekerjaanAyah = pekerjaanAyah,
                namaIbu = namaIbu,
                alamatIbu = alamatIbu,
                pekerjaanIbu = pekerjaanIbu
            )

            data.document(idMutasiSiswa).set(insertData).await()
        }
    }
}