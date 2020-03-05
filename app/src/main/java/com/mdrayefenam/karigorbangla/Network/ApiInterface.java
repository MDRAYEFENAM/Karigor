package com.mdrayefenam.karigorbangla.Network;

import com.mdrayefenam.karigorbangla.RegisterModel.RegisterResponse;
import com.mdrayefenam.karigorbangla.Responce.LoginModel.LoginResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("auth/user_login")
    Call<LoginResponce> userLogin(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/user_register")
    Call<RegisterResponse> userRegister(@Field("name") String name, @Field("email") String email , @Field("mobile") String mobile , @Field("password") String password);






}
