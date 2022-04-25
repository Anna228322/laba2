package com.example.domain.usecases.getuserinfo

import com.example.domain.models.UserInfo

interface IGetUserInfoUseCase {
    suspend fun getUserInfo(): UserInfo
}