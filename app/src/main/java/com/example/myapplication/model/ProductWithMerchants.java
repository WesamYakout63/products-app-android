package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class ProductWithMerchants {


    private Product Product;
    private List<ProductMerchants> ProductMerchants = new ArrayList<>();

    public ProductWithMerchants(Product product, List<ProductMerchants> productMerchants)
    {
        this.Product = product;
        this.ProductMerchants = productMerchants;
    }

    public Product getProduct() {
        return Product;
    }

    public List<ProductMerchants> getMerchants() {
        return ProductMerchants;
    }

    public String get()
    {
        String s = "Product : " + "\n" + Product.get_Prouduct() + "\n\n" +
                "Product_Merchants : " + "\n";
        for (int i = 0 ; i < ProductMerchants.size() ; i++)
        {
            s += ProductMerchants.get(i).get_merchants() + "\n";
        }
        return s;
    }

    public void add(ProductMerchants productMerchants) {
        this.ProductMerchants.add(productMerchants);
    }
}
