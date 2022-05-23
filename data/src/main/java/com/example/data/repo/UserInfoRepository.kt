package com.example.data.repo

import com.example.data.dao.UserInfoDao
import com.example.data.models.UserInfoEntity
import com.example.domain.models.UserInfo
import com.example.domain.repository.IUserInfoRepository
import com.example.network.retrofit.RetrofitClient
import javax.inject.Inject

class UserInfoRepository @Inject constructor(
    private val retrofitClient: RetrofitClient,
    private val UserInfoDao: UserInfoDao
) : IUserInfoRepository {
    override suspend fun getUserInfo(): UserInfo {
        val fromDb = UserInfoDao.getAll()
        return if (fromDb.isNotEmpty()) {
            val entity = fromDb[0]
            UserInfo(entity.firstName, entity.lastName, entity.address, entity.id)
        } else {
            val fromApi = retrofitClient.getClient().getUserInfo()[0]
            val mapped = UserInfoEntity(fromApi.firstName, fromApi.lastName, fromApi.address, fromApi.id)
            UserInfoDao.saveAll(mapped)
            fromApi
        }
    }
}