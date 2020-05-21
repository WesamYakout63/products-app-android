package com.example.myapplication.model;

public class ProductMerchant {

    private String id;
    private String product_id;
    private String upc;
    private String sku;
    private String created;
    private String modified;
    private String multiple_products_per_page;

    public ProductMerchant(String id, String product_id, String upc, String sku,
                           String created, String modified, String multiple_products_per_page)
    {
        this.id = id;
        this.product_id = product_id;
        this.upc = upc;
        this.sku = sku;
        this.created = created;
        this.modified = modified;
        this.multiple_products_per_page = multiple_products_per_page;
    }

    public ProductMerchant() {
    }

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getUpc() {
        return upc;
    }

    public String getSku() {
        return sku;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public String getMultiple_products_per_page() {
        return multiple_products_per_page;
    }

    public String get_Product_Merchant() {
        return "id : " + id + "\n" + "product_id : " + product_id + "\n" +
                "upc : " + upc + "\n" + "sku : " + sku + "\n" + "created : " + created +
                "\n" + "modified : " + modified + "\n" + "multiple_products_per_page : "
                + multiple_products_per_page + "\n";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setMultiple_products_per_page(String multiple_products_per_page) {
        this.multiple_products_per_page = multiple_products_per_page;
    }
}
