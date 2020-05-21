package com.example.myapplication.controllers;

import android.content.Context;
import android.os.AsyncTask;

import com.example.myapplication.model.DBHelper;
import com.example.myapplication.model.ProductWithMerchants;

import java.util.List;

public class DBAsyncTask extends AsyncTask<List<ProductWithMerchants> , Void , Void> {
    private Context context;
    private DBHelper dbHelper;
    private CallBack2 callBack2;

    public DBAsyncTask(Context context , CallBack2 callBack2) {
        this.context = context;
        this.callBack2 = callBack2;
        dbHelper =  new DBHelper(this.context);
    }


    @Override
    protected Void doInBackground(List<ProductWithMerchants>... lists) {
        dbHelper.refreshTables();
        for (int i = 0 ; i < lists[0].size() ; i++)
        {
            dbHelper.createProduct(lists[0].get(i).getProduct());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        callBack2.sending(dbHelper.getProduct());
    }
}
