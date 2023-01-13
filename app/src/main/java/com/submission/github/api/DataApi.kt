package com.submission.github.api

import com.submission.github.data.UsersList
import com.submission.github.data.UsersDetail
import com.submission.github.data.UsersItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface DataApi {
    @GET("search/users")
    fun getListUsers(
        @Query("q") username: String,
        @Header("Authorization") token: String
    ): Call<UsersList>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username: String
    ): Call<UsersDetail>

    @GET("users/{username}/followers")
    fun getListFollowers(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Call<List<UsersItems>>

    @GET("users/{username}/following")
    fun getListFollowing(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Call<List<UsersItems>>
}