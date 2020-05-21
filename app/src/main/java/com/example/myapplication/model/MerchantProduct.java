package com.example.myapplication.model;

public class MerchantProduct {

    private String id;
    private String price;
    private String upc;
    private String sku;
    private String buy_url;
    private String discount_percent;
    private String unit_price;

    public MerchantProduct(String id, String price, String upc, String sku,
                           String buy_url, String discount_percent, String unit_price)
    {
        this.id = id;
        this.price = price;
        this.upc = upc;
        this.sku = sku;
        this.buy_url = buy_url;
        this.discount_percent = discount_percent;
        this.unit_price = unit_price;
    }

    public MerchantProduct() {
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getUpc() {
        return upc;
    }

    public String getSku() {
        return sku;
    }

    public String getBuy_url() {
        return buy_url;
    }

    public String getDiscount_percent() {
        return discount_percent;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public String get_Merchant_Product() {
        return "id : " + id + "\n" + "price : " + price + "\n" + "upc : " + upc + "\n"
                + "sku : " + sku + "\n" + "buy_url : " + buy_url + "\n" +
                "discount percent : " + discount_percent + "\n" + "unit_price : " +
                unit_price + "\n";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setBuy_url(String buy_url) {
        this.buy_url = buy_url;
    }

    public void setDiscount_percent(String discount_percent) {
        this.discount_percent = discount_percent;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }
}
