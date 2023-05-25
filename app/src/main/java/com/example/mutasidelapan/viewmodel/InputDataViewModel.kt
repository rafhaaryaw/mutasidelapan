package com.example.mutasidelapan.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mutasidelapan.repository.InputDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InputDataViewModel : ViewModel() {

    private var repository: InputDataRepository = InputDataRepository()

    fun inputData(
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
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(
                nama,
                kelas,
                nisn,
                nik,
                tempatTanggalLahir,
                alamat,
                mutasiDariSekolah,
                mutasiKeSekolah,
                mutasiDariKelas,
                mutasiKeKelas,
                mutasiDariJurusan,
                mutasiKeJurusan,
                tanggalMutasi,
                keteranganMutasi,
                fotoSiswa,
                namaAyah,
                alamatAyah,
                pekerjaanAyah,
                namaIbu,
                alamatIbu,
                pekerjaanIbu)
        }
    }
}