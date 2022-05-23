package com.example.domain.usecases.getuserinfo


import com.example.domain.models.UserInfo
import com.example.domain.repository.IUserInfoRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repo: IUserInfoRepository
): IGetUserInfoUseCase {
    override suspend fun getUserInfo(): UserInfo = repo.getUserInfo()
}