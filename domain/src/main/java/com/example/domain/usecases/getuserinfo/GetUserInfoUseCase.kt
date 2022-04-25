package com.example.domain.usecases.getuserinfo


import com.example.domain.models.UserInfo
import com.example.domain.repository.IUserInfoRepository

class GetUserInfoUseCase (
    private val repo: IUserInfoRepository
): IGetUserInfoUseCase {
    override suspend fun getUserInfo(): UserInfo = repo.getUserInfo()
}