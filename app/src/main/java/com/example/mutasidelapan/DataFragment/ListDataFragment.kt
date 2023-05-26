package com.example.mutasidelapan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mutasidelapan.Activity.ProfilActivity
import com.example.mutasidelapan.data.InputDataModel
import com.example.mutasidelapan.databinding.FragmentListDataBinding
import com.example.mutasidelapan.viewmodel.ListDataViewModel


class ListDataFragment : Fragment() {

    private lateinit var binding: FragmentListDataBinding

    private val viewModel: ListDataViewModel by viewModels()
    private lateinit var adapter: ListUsersAdapter
    private var listData = listOf<InputDataModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllData {
            listData = it
            showRecyclerList()
        }
    }

    private fun showRecyclerList() {
        binding.rvListData.layoutManager = LinearLayoutManager(context)
        adapter = ListUsersAdapter(listData)
        binding.rvListData.adapter = this@ListDataFragment.adapter

        adapter.setOnItemClickCallback(object: ListUsersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: InputDataModel) {
                showSelectedData(data)
            }
        })
    }

    private fun showSelectedData(data: InputDataModel) {
        val intent = Intent(context, ProfilActivity::class.java)
        intent.putExtra("MutasiDataID", data.id)
        startActivity(intent)
    }
}


