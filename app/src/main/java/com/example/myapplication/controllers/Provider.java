package com.example.myapplication.controllers;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.model.DBHelper;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.ProductWithMerchants;

import java.util.List;

import static com.example.myapplication.model.DBHelper.COLUMN_ID;
import static com.example.myapplication.model.DBHelper.PRODUCT_TABLE;
import static com.example.myapplication.model.DBHelper.PRODUCT_TABLE_COLUMNS;
import static com.example.myapplication.model.DBHelper.PRO_DESCRIPTION;
import static com.example.myapplication.model.DBHelper.PRO_ID;
import static com.example.myapplication.model.DBHelper.PRO_IMAGE_URL;
import static com.example.myapplication.model.DBHelper.PRO_NAME;
import static com.example.myapplication.model.DBHelper.PRO_PRICE;
import static com.example.myapplication.model.DBHelper.PRO_PRODUCT_TYPE_ID;
import static com.example.myapplication.model.DBHelper.PRO_SHOPPING_CART_ITEM_ID;
import static com.example.myapplication.model.DBHelper.PRO_SHOPPING_LIST_ITEM_ID;
import static com.example.myapplication.model.DBHelper.PRO_UNIT_PRICE;

public class Provider extends ContentProvider {

    private SQLiteDatabase db;

    private static final String AUTHORITY = "com.example.myapplication.controllers";
    private static final String BASEPATH = "products";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASEPATH);

    private static final int PRODUCT_TABLE_CODE = 1;
    private static final int PRODUCT_TABLE_ID = 2;


    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, BASEPATH , PRODUCT_TABLE_CODE);
        uriMatcher.addURI(AUTHORITY, BASEPATH + "/#" , PRODUCT_TABLE_ID);
    }

    @Override
    public boolean onCreate() {
        DBHelper helper = new DBHelper(getContext());
        db = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor;
        switch (uriMatcher.match(uri)) {
            case PRODUCT_TABLE_CODE:
                cursor = db.query(PRODUCT_TABLE , PRODUCT_TABLE_COLUMNS , selection ,
                        null, null, null,   COLUMN_ID + " ASC");
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case PRODUCT_TABLE_CODE:
                return "vnd.android.cursor.dir/products";
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long id = db.insert(PRODUCT_TABLE , null, values);

        if (id > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(_uri, null);

            return _uri;
        }
        throw new SQLException("Insertion Failed for URI :" + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int delCount = 0;
        switch (uriMatcher.match(uri)) {
            case PRODUCT_TABLE_CODE:
                delCount = db.delete(PRODUCT_TABLE , selection , selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return delCount;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int updCount = 0;
        switch (uriMatcher.match(uri)) {
            case PRODUCT_TABLE_CODE:
                updCount = db.update(PRODUCT_TABLE, values , selection , selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return updCount;
    }
}
