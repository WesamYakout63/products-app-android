package com.example.myapplication.model;

public class Merchant {

    private String id;
    private String name;

    public Merchant() {
    }

    public Merchant(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getID()
    {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String get_merch() {
        return "id :" + id + "\n" + "name : " + name + "\n";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
