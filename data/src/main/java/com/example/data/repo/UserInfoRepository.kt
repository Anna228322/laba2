package com.example.data.repo

import com.example.data.dao.UserInfoDao
import com.example.data.models.UserInfoEntity
import com.example.domain.models.UserInfo
import com.example.domain.repository.IUserInfoRepository
import com.example.network.retrofit.ApiProvider

class UserInfoRepository(
    private val apiProvider: ApiProvider,
    private val UserInfoDao: UserInfoDao
) : IUserInfoRepository {
    override suspend fun getUserInfo(): UserInfo {
        val fromDb = UserInfoDao.getAll()
        return if (fromDb.isNotEmpty()) {
            val entity = fromDb[0]
            UserInfo(entity.firstName, entity.lastName, entity.address, entity.id)
        } else {
            val fromApi = apiProvider.getApi().getUserInfo()[0]
            val mapped = UserInfoEntity(fromApi.firstName, fromApi.lastName, fromApi.address, fromApi.id)
            UserInfoDao.saveAll(mapped)
            fromApi
        }
    }
}