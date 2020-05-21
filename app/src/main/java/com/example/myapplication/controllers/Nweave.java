package com.example.myapplication.controllers;

import com.example.myapplication.model.ProductWithMerchants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Nweave {
    public static final String URL = "http://www.nweave.com/";

    @GET("wp-content/uploads/2012/09/featured.txt")
    Call<List<ProductWithMerchants>> get();

}
