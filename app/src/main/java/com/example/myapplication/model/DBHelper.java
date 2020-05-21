package com.example.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "products";

    public static final String PRODUCT_TABLE = "Product";

    public static final String COLUMN_ID = "id";
    public static final String PRO_ID = "p_id";
    public static final String PRO_NAME = "name";
    public static final String PRO_DESCRIPTION = "description";
    public static final String PRO_PRICE = "price";
    public static final String PRO_UNIT_PRICE = "unit_price";
    public static final String PRO_PRODUCT_TYPE_ID = "product_type_id";
    public static final String PRO_IMAGE_URL = "image_url";
    public static final String PRO_SHOPPING_LIST_ITEM_ID = "shopping_list_item_id";
    public static final String PRO_SHOPPING_CART_ITEM_ID = "shopping_cart_item_id";

    public static final String [] PRODUCT_TABLE_COLUMNS = {COLUMN_ID , PRO_ID , PRO_NAME , PRO_DESCRIPTION ,
            PRO_PRICE , PRO_UNIT_PRICE , PRO_PRODUCT_TYPE_ID , PRO_IMAGE_URL , PRO_SHOPPING_LIST_ITEM_ID ,
            PRO_SHOPPING_CART_ITEM_ID};

    public static final String CREATE_PRODUCT_TABLE =
            "CREATE TABLE " + PRODUCT_TABLE + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + PRO_ID + " TEXT,"
                    + PRO_NAME + " TEXT," + PRO_DESCRIPTION + " TEXT," + PRO_PRICE +
                    " TEXT," + PRO_UNIT_PRICE + " TEXT," + PRO_PRODUCT_TYPE_ID +
                    " TEXT," + PRO_IMAGE_URL + " TEXT," + PRO_SHOPPING_LIST_ITEM_ID +
                    " TEXT," + PRO_SHOPPING_CART_ITEM_ID + " TEXT" + ")";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
        onCreate(db);
    }

    public long createProduct(Product product) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues productDetails = new ContentValues();
        productDetails.put(PRO_ID, product.getId());
        productDetails.put(PRO_NAME, product.getName());
        productDetails.put(PRO_DESCRIPTION, product.getDescription());
        productDetails.put(PRO_PRICE, product.getPrice());
        productDetails.put(PRO_UNIT_PRICE, product.getUnit_price());
        productDetails.put(PRO_PRODUCT_TYPE_ID, product.getProduct_type_id());
        productDetails.put(PRO_IMAGE_URL, product.getImage_url());
        productDetails.put(PRO_SHOPPING_LIST_ITEM_ID, product.getShopping_list_item_id());
        productDetails.put(PRO_SHOPPING_CART_ITEM_ID, product.getShopping_cart_item_id());

        // insert row
        long id = db.insert(PRODUCT_TABLE , null, productDetails);

        return id;
    }

    public List<Product> getProduct() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + PRODUCT_TABLE;
        List<Product> productList = new ArrayList<>();

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(c.getString(c.getColumnIndex(PRO_ID)));
                product.setName((c.getString(c.getColumnIndex(PRO_NAME))));
                product.setDescription(c.getString(c.getColumnIndex(PRO_DESCRIPTION)));
                product.setPrice(c.getString(c.getColumnIndex(PRO_PRICE)));
                product.setUnit_price(c.getString(c.getColumnIndex(PRO_UNIT_PRICE)));
                product.setProduct_type_id(c.getString(c.getColumnIndex(PRO_PRODUCT_TYPE_ID)));
                product.setDescription(c.getString(c.getColumnIndex(PRO_DESCRIPTION)));
                product.setImage_url(c.getString(c.getColumnIndex(PRO_IMAGE_URL)));
                product.setShopping_list_item_id(c.getString(c.getColumnIndex(PRO_SHOPPING_LIST_ITEM_ID)));
                product.setShopping_cart_item_id(c.getString(c.getColumnIndex(PRO_SHOPPING_CART_ITEM_ID)));

                productList.add(product);
            } while (c.moveToNext());
        }
        return productList;
    }

    public void refreshTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + PRODUCT_TABLE);
    }
}
