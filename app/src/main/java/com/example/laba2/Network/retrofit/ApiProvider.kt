package com.example.laba2.Network.retrofit

class ApiProvider(private val client: RetrofitClient) {
    private val baseUrl = "https://61f5894b62f1e300173c41ba.mockapi.io/"

    fun getApi(): IApi =
        client.getClient(baseUrl)
            .create(IApi::class.java)
}