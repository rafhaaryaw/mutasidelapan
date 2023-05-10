package com.example.mutasidelapan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListData(
    var nama: String = "",
    var kelas: String = "",
    var jurusan: String = "",
    var photo: Int = 0
) : Parcelable
