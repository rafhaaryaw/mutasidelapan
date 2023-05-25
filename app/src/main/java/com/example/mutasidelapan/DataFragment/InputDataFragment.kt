package com.example.mutasidelapan.DataFragment

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mutasidelapan.databinding.FragmentInputDataBinding
import com.example.mutasidelapan.viewmodel.InputDataViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import java.io.File

class InputDataFragment : Fragment() {

    private lateinit var binding: FragmentInputDataBinding

    private val viewModel: InputDataViewModel by viewModels()

    private var currentImageUri: Uri? = null
    //private var selectedPicture: File? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentInputDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddImage.setOnClickListener {
            ImagePicker.with(requireActivity())
                .crop()
                .saveDir(
                    File(
                        activity?.externalCacheDir,
                        "ImagePicker"
                    )
                ) //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }

        binding.btnSubmit.setOnClickListener {
            handleInputData()
        }
    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {
                    //Image Uri will not be null for RESULT_OK
                    val fileUri = data?.data!!
                    binding.ivProfileDiri.setImageURI(fileUri)
                    fileUri.path?.let {
                        val file = File(it)
                        if (file.exists()) {
                            currentImageUri = fileUri
                        }
                    }
                }
                ImagePicker.RESULT_ERROR -> {
                    Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
                }
            }
        }


    private fun handleInputData() {
        if (currentImageUri == null) {
            Toast.makeText(context, "Foto harus diisi", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.inputData(
                binding.edtNama.text.toString(),
                binding.edtKelas.text.toString(),
                binding.edtNisn.text.toString(),
                binding.edtNik.text.toString(),
                binding.edtTempatTanggalLahir.text.toString(),
                binding.edtAlamat.text.toString(),
                binding.edtMutasiDari.text.toString(),
                binding.edtMutasiKe.text.toString(),
                binding.edtDariKelas.text.toString(),
                binding.edtKeKelas.text.toString(),
                binding.edtDariJurusan.text.toString(),
                binding.edtKeJurusan.text.toString(),
                binding.edtTanggalMutasi.text.toString(),
                binding.edtKeteranganMutasi.text.toString(),
                currentImageUri!!,
                binding.edtNamaAyah.text.toString(),
                binding.edtAlamatAyah.text.toString(),
                binding.edtPekerjaanAyah.text.toString(),
                binding.edtNamaIbu.text.toString(),
                binding.edtAlamatIbu.text.toString(),
                binding.edtPekerjaanIbu.text.toString()
            )
        }
    }
}