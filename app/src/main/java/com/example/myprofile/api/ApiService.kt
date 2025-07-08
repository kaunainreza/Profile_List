package com.example.myprofile.api

import com.example.myprofile.models.ProfileDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileApi {
    @GET("todos")
    suspend fun getProfiles(): List<ProfileDto>

    @GET("todos/{id}")
    suspend fun getProfileById(@Path("id") id: Int): ProfileDto
}