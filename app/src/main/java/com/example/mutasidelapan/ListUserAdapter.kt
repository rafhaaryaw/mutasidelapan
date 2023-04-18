package com.example.mutasidelapan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListUsersAdapter(private val listUser: ArrayList<ListData>) : RecyclerView.Adapter<ListUsersAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.findViewById(R.id.tv_nama_siswa)
        var tvKelas: TextView = itemView.findViewById(R.id.tv_kelas)
        var tvJurusan: TextView = itemView.findViewById(R.id.tv_jurusan_siswa)
        var ivPhoto: ImageView = itemView.findViewById(R.id.img_profil_siswa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_data, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listuser = listUser[position]
        Glide.with(holder.itemView.context)
            .load(listuser.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.ivPhoto)
        holder.tvNama.text = listuser.nama
        holder.tvKelas.text = listuser.kelas
        holder.tvJurusan.text = listuser.jurusan
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ListData)

    }
}
