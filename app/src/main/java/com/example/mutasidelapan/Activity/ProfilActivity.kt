package com.example.mutasidelapan.Activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mutasidelapan.databinding.ActivityProfilBinding
import com.example.mutasidelapan.viewmodel.ListDataViewModel

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    private var dataMutasiId: String? = null

    private val viewModel: ListDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataMutasiId = intent.getStringExtra("MutasiDataID")
        viewModel.getDetailDataMutasi(dataMutasiId!!) { dataMutasi ->
            binding.inputTvNamaSiswa.text = dataMutasi.nama
            binding.outputTvKelas.text = dataMutasi.kelas
            binding.outputTvNisn.text = dataMutasi.nisn
            binding.outputTvNik.text = dataMutasi.nik
            binding.outputTvTTL.text = dataMutasi.tempatTanggalLahir
            binding.outputTvAlamat.text = dataMutasi.alamat
            binding.outputTvMutasidari.text = dataMutasi.mutasiDariSekolah
            binding.outputTvJurusan.text = dataMutasi.mutasiKeJurusan
            binding.outputTvNamaAyah.text = dataMutasi.namaAyah
            binding.outputTvNamaIbu.text = dataMutasi.namaIbu
            binding.outputTvPekerjaanAyah.text = dataMutasi.pekerjaanAyah
            binding.outputTvPekerjaanIbu.text = dataMutasi.pekerjaanIbu
            binding.outputTvAlamatAyah.text = dataMutasi.alamatAyah
            binding.outputTvAlamatIbu.text = dataMutasi.alamatIbu
            Glide.with(this)
                .load(dataMutasi.fotoSiswaUrl)
                .into(binding.imageView4)
        }




    }
}