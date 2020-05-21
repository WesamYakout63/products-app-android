package com.example.myapplication.controllers;

import android.util.Log;

import com.example.myapplication.model.ProductWithMerchants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepo {

    private CallBack callBack;

    public RetrofitRepo(CallBack callBack) {
        this.callBack = callBack;
    }

    public void get_the_list()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Nweave.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Nweave node = retrofit.create(Nweave.class);

        Call<List<ProductWithMerchants>> call = node.get();

        call.enqueue(new Callback<List<ProductWithMerchants>>() {
            @Override
            public void onResponse(Call<List<ProductWithMerchants>> call, Response<List<ProductWithMerchants>> response) {
                List<ProductWithMerchants> tempList = response.body();
                callBack.sending(tempList);
            }

            @Override
            public void onFailure(Call<List<ProductWithMerchants>> call, Throwable throwable) {
                Log.i("False" , "Null is returned");
            }
        });
    }
}

