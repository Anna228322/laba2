package com.example.domain.repository

import com.example.domain.models.UserInfo

interface IUserInfoRepository {
    suspend fun getUserInfo(): UserInfo
}