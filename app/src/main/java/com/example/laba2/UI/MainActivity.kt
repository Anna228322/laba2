package com.example.laba2.UI

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Tariff
import com.example.laba2.App
import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.RetrofitClient
import com.example.laba2.R
import com.example.laba2.databinding.ActivityMainBinding
import com.example.laba2.viewmodel.IMainViewModel
import com.example.laba2.viewmodel.ViewModelFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var factory: ViewModelFactory
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<IMainViewModel>{ factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()
        setView()
        setAdapter()
        subscribe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    private fun subscribe() {
        viewModel.loading.observe(this){
            binding.loading.isVisible = it
        }
        viewModel.tariffs.observe(this){
            setTariffs(it.map{ mapTariffToItem(it)})
        }
        viewModel.balance.observe(this) {
            with(binding) {
                balanceSum.text = it.balance.toString()
                kOplate.text = getString(R.string.k_oplate).format(it.nextPay)
                ls.text = getString(R.string.Lic_schet).format(it.accNum)
            }
        }
        viewModel.userInfo.observe(this){
            with(binding) {
                name.text = "${it.firstName} ${it.lastName}"
                address.text = it.address
            }
        }
    }

    private fun inject() {
        App.appComponent.inject(this)
    }

    private fun mapTariffToItem(tariff: Tariff) =
        Item(
            title = tariff.title,
            subtitle = tariff.desc,
            price = tariff.cost
        )

    private fun setTariffs(list: List<Item>) {
        adapter.submitList(list)
    }

    private fun setView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setAdapter() {
        adapter = Adapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false,
        )
    }
}


