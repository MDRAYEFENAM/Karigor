package com.mdrayefenam.karigorbangla.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private static final String BASE_URL="https://karigorbangla.000webhostapp.com/api/";
    private static RetrofitClient retrofitClient;


    private RetrofitClient() {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private RetrofitClient(final String token){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "bearer"+token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();



        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }


    public static synchronized RetrofitClient getInstance(String token) {
        return new RetrofitClient(token);
    }


    public ApiInterface getApiInterface() {
        return retrofit.create(ApiInterface.class);
    }

}
