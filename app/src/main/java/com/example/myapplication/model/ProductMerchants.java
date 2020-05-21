package com.example.myapplication.model;

public class ProductMerchants {

    private Merchant Merchant;
    private MerchantProduct MerchantProduct;
    private ProductMerchant ProductMerchant;

    public ProductMerchants(Merchant merchant, MerchantProduct merchantProduct,
                            ProductMerchant productMerchant)
    {
        this.Merchant = merchant;
        this.MerchantProduct = merchantProduct;
        this.ProductMerchant = productMerchant;
    }

    public Merchant getMerchant() {
        return Merchant;
    }

    public MerchantProduct getMerchantProduct() {
        return MerchantProduct;
    }

    public ProductMerchant getProductMerchant() {
        return ProductMerchant;
    }

    public String get_merchants() {
        return "Merchant : " + "\n" +  Merchant.get_merch() + "\n\n" + "MerchantProduct : " +
        "\n" + MerchantProduct.get_Merchant_Product() + "\n\n" + "ProductMerchant : " + "\n"
        + ProductMerchant.get_Product_Merchant() + "\n\n";
    }
}
