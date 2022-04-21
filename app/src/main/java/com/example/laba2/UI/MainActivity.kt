package com.example.laba2.UI

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba2.Network.models.Tariff
import com.example.laba2.Network.models.UserInfo
import com.example.laba2.Network.retrofit.ApiProvider
import com.example.laba2.Network.retrofit.RetrofitClient
import com.example.laba2.R
import com.example.laba2.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding

    private val api = ApiProvider(RetrofitClient()).getApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setView()
        setAdapter()
        load()
    }

    private fun load() {
        MainScope().launch {
            binding.loading.isVisible = true

            loadBalance()
            loadTariffs()
            loadUserInfo()
        }
    }

    private suspend fun loadTariffs() {
        val tariffs = api.getTariffs()
        val items = tariffs.map(::mapTariffToItem)
        setTariffs(items)
        binding.loading.isVisible = false
    }

    private suspend fun loadUserInfo() {
        val user = api.getUserInfo()[0]
        with(binding) {
            name.text = "${user.firstName} ${user.lastName}"
            address.text = user.address
            loading.isVisible = false
        }
    }

    private suspend fun loadBalance() {
        val balance = api.getBalance()[0]
        with(binding) {
            balanceSum.text = balance.balance.toString()
            kOplate.text = getString(R.string.k_oplate).format(balance.nextPay)
            ls.text = getString(R.string.Lic_schet).format(balance.accNum)
            loading.isVisible = false
        }
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


