package com.example.mutasidelapan

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mutasidelapan.databinding.ItemUserBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class ListUsersAdapter(private val listUser : ArrayList<ListData>) : RecyclerView.Adapter<ListUsersAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivPhotoSiswa: ImageView = itemView.findViewById(R.id.iv_Foto_siswa)
        var tvNamaSiswa: TextView = itemView.findViewById(R.id.tv_nama_siswa)
        var tvKelasSiswa: TextView = itemView.findViewById(R.id.tv_kelas_siswa)
        var tvJurusanSiswa: TextView = itemView.findViewById(R.id.tv_jurusan_siswa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.ivPhotoSiswa)
        holder.tvNamaSiswa.text = user.nama
        holder.tvKelasSiswa.text = user.kelas
        holder.tvJurusanSiswa.text = user.jurusan

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: ListData)
    }
}
