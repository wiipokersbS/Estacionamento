package com.example.estacionamento.Conexao;

import android.widget.EditText;

import com.example.estacionamento.Array.Estacionamento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

   /* @POST("get_pets.php")
    Call<List<Estacionamento>> getPets();*/

    @FormUrlEncoded
    @POST("create.php")
    Call<Estacionamento> insertEstacionamento(
            @Field("nomeFantasia") EditText nomeFantasia,
            @Field("razaoSocial") EditText razaoSocial,
            @Field("cnpj") EditText cnpj,
            @Field("cep") EditText cep,
            @Field("numero") EditText numero,
            @Field("bairro") EditText bairro,
            @Field("estado") EditText estado,
            @Field("cidade") EditText cidade);

/*    @FormUrlEncoded
    @POST("update_pet.php")
    Call<Estacionamento> updatePet(
            @Field("key") String key,
            @Field("id") int id,
            @Field("name") String name,
            @Field("species") String species,
            @Field("breed") String breed,
            @Field("gender") int gender,
            @Field("birth") String birth,
            @Field("picture") String picture);*/

/*    @FormUrlEncoded
    @POST("delete_pet.php")
    Call<Estacionamento> deletePet(
            @Field("key") String key,
            @Field("id") int id,
            @Field("picture") String picture);*/

    /*@FormUrlEncoded
    @POST("update_love.php")
    Call<Estacionamento> updateLove(
            @Field("key") String key,
            @Field("id") int id,
            @Field("love") boolean love);*/

}
