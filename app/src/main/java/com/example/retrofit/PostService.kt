package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

//Camada PostService que mapeia a URL (possiveis parametros)

interface PostService {

    //Camada PostService que mapeia a URL (possiveis parametros)
    @GET("posts")


    //fun list(""parametro""): Call<""retorno"">
    fun list(): Call<List<PostModel>>

}