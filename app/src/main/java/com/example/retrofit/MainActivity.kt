package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         idTextView.setText("oi")

        // Client onde é criado a instancia do serviço
        val remote = RetrofitClient.criarServico(PostService::class.java)
        // Utiliza o Client con funções da interface

        val call : Call<List<PostModel>> = remote.list()

        // Coloca em uma lista para executar assincronamente
        val response = call.enqueue(object : Callback<List<PostModel>>{
            override fun onResponse( call: Call<List<PostModel>>, response: Response<List<PostModel>>) {


                val s = response.body()
                idTextView.setText(s.toString() + ", porém deu bom")


            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
                idTextView.setText(s.toString() + ", então deu ruim")
            }
        })


    }
}