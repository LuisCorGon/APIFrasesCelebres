package com.luiscortes.apifrasescelebres.api;

import com.luiscortes.apifrasescelebres.models.Autor;
import com.luiscortes.apifrasescelebres.models.Categoria;
import com.luiscortes.apifrasescelebres.models.Frase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApiService {

    @GET("frase/dia/{fechaProgramada}")
    Call<Frase> getFraseDia(@Path("fechaProgramada") String fechaProgramada);
    @GET("frase/autor/{id}")
    Call<List<Frase>> getFraseAutorById(@Path("id") int id);

    @GET("frase/categoria/{id}")
    Call<List<Frase>> getFraseCategoriaById(@Path("id") int id);

    @GET("autor/all")
    Call<List<Autor>> getAllAutores();

    @GET("categoria/all")
    Call<List<Categoria>> getAllCategorias();


}
