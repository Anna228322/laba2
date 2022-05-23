package com.example.laba2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba2.R
import com.example.laba2.databinding.FragmentTariffsBinding
import com.example.laba2.di.factory
import com.example.laba2.viewmodel.IMainViewModel

class TariffsFragment: Fragment() {
    private val viewModel by viewModels<IMainViewModel> { factory }

    private lateinit var adapter: Adapter

    private lateinit var binding: FragmentTariffsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTariffsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        subscribe()
        viewModel.refreshData()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun subscribe() {
        viewModel.loading.observe(requireActivity()){
            binding.loading.isVisible = it
        }
        viewModel.tariffs.observe(requireActivity()){
            adapter.submitList(it.map{
                Item(
                    title = it.title,
                    subtitle = it.desc,
                    price = it.cost,
                    deleteButton = {viewModel.delete(it) }
                )
            })
        }
        viewModel.balance.observe(requireActivity()) {
            with(binding) {
                balanceSum.text = it.balance.toString()
                kOplate.text = getString(R.string.k_oplate).format(it.nextPay)
                ls.text = getString(R.string.Lic_schet).format(it.accNum)
            }
        }
        viewModel.userInfo.observe(requireActivity()){
            with(binding) {
                name.text = "${it.firstName} ${it.lastName}"
                address.text = it.address
            }
        }
    }

    private fun setAdapter() {
        adapter = Adapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false,
        )
    }
}