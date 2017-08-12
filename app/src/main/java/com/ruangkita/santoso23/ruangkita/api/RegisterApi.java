package com.ruangkita.santoso23.ruangkita.api;

import com.ruangkita.santoso23.ruangkita.model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by santoso on 8/8/17.
 */

public interface RegisterApi {
    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("nama") String nama,
            @Field("jenis_kelamin") String jenisKelamin
            );

    @GET("view.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("search.php")
    Call<Value> search(@Field("search")String search);

    @FormUrlEncoded
    @POST("delete.php")
    Call<Value> hapus(@Field("username")String username);

    @FormUrlEncoded
    @POST("update.php")
    Call<Value> ubah(
            @Field("password") String password,
            @Field("email") String email,
            @Field("nama") String nama,
            @Field("jenis_kelamin") String jenisKelamin,
            @Field("username") String username
    );

}



