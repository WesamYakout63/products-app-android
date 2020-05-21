package com.example.myapplication.model;

public class Product {

    private String id;
    private String name;
    private String description;
    private String price;
    private String unit_price;
    private String product_type_id;
    private String image_url;
    private String shopping_list_item_id;
    private String shopping_cart_item_id;


    public Product() {
    }


    public Product(String id, String name, String description, String price,
                   String unit_price, String product_type_id, String image_url,
                   String shopping_list_item_id, String shopping_cart_item_id)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit_price = unit_price;
        this.product_type_id = product_type_id;
        this.image_url = image_url;
        this.shopping_list_item_id = shopping_list_item_id;
        this.shopping_cart_item_id = shopping_cart_item_id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public String getProduct_type_id() {
        return product_type_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getShopping_list_item_id() {
        return shopping_list_item_id;
    }

    public String getShopping_cart_item_id() {
        return shopping_cart_item_id;
    }

    public String get_Prouduct() {
        return "id : " + id + "\n" + "name : " + name + "\n" + "description : " + description
                + "\n" + "price : " + price + "\n" + "unit_price : " + unit_price + "\n" +
                "product_type_id : " + product_type_id + "\n" + "image_url : " + image_url +
                "\n" + "shopping_list_item_id : " + shopping_list_item_id + "\n" +
                "shopping_cart_item_id : " + shopping_cart_item_id + "\n";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public void setProduct_type_id(String product_type_id) {
        this.product_type_id = product_type_id;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setShopping_list_item_id(String shopping_list_item_id) {
        this.shopping_list_item_id = shopping_list_item_id;
    }

    public void setShopping_cart_item_id(String shopping_cart_item_id) {
        this.shopping_cart_item_id = shopping_cart_item_id;
    }
}
