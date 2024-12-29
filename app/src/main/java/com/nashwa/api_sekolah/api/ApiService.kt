package com.nashwa.api_sekolah.api

import com.nashwa.api_sekolah.model.LoginResponse
import com.nashwa.api_sekolah.model.RegisterResponse
import com.nashwa.api_sekolah.model.SekolahResponse
import com.nashwa.api_sekolah.model.TambahSekolahResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query
interface ApiService {
    @FormUrlEncoded
    @POST("api_sekolah/register.php")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("fullname") fullname: String,
        @Field("email") email: String,

        ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("api_sekolah/login.php")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,


        ): Call<LoginResponse>

    @GET("api_sekolah/get_sekolah.php")
    fun getListSekolah(@Query("nama") nama: String): Call<SekolahResponse>


    @Multipart
    @POST("api_sekolah/add_sekolah.php")
    fun addSekolah(
        @Part("nama") nama: RequestBody,
        @Part("no_telp") no_telp: RequestBody,
        @Part("akreditasi") akreditasi: RequestBody,
        @Part("informasi_sekolah") informasi_sekolah: RequestBody,
        @Part gambar : MultipartBody.Part
    ): Call<TambahSekolahResponse>
}

//    @POST("API_BASIC/register.php")
//    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
//
//    @POST("API_BASIC/login.php")
//    fun login(@Body request: LoginRequest): Call<LoginResponse>