package com.example.myapplication.controllers;


import com.example.myapplication.model.ProductWithMerchants;

import java.util.List;

public interface CallBack {

    void sending(List<ProductWithMerchants> productWithMerchantsList);
}
