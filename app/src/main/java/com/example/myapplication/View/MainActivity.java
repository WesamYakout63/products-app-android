package com.example.myapplication.view;

import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.controllers.Adapter;
import com.example.myapplication.controllers.DBAsyncTask;
import com.example.myapplication.controllers.Listener;
import com.example.myapplication.controllers.RetrofitRepo;
import com.example.myapplication.controllers.TouchListener;
import com.example.myapplication.model.DBHelper;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.ProductWithMerchants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.controllers.Provider.CONTENT_URI;
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

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private List<Product> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private Adapter adapter;
    private DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        recyclerView.addOnItemTouchListener(new TouchListener(this , recyclerView , new Listener() {
            @Override
            public void onClick(View view, int position) {
                View view1 = view.findViewById(R.id.cardView);
                ImageView image = view1.findViewById(R.id.imageView);
                Intent i = new Intent(MainActivity.this , DetailsActivity.class);
                i.putExtra("Image" , ((BitmapDrawable) image.getDrawable()).getBitmap());
                i.putExtra("Details" , productList.get(position).get_Prouduct());
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        if(productList.isEmpty())
            use_retrofit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "the list size is " + productList.size() , Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ProgressDialog(String msg) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading ...");
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    public void use_retrofit() {

        ProgressDialog("Parsing JSON feed...");
        RetrofitRepo retrofit_cont = new RetrofitRepo(productWithMerchantsList -> {
            progressDialog.hide();
            insertProduct(productWithMerchantsList);
            ProgressDialog("Reading from the internal storage ...");
            Log.d("Exited after inserting" , String.valueOf(insertProduct(productWithMerchantsList)));
            getLoaderManager().initLoader(0 , null , this);
            progressDialog.hide();

//            progressDialog.hide();
//            ProgressDialog("Reading from the internal storage ...");
//            DBAsyncTask writeOnDB = new DBAsyncTask(this, productWithMerchantsList1 -> {
//                productList = new ArrayList<>(productWithMerchantsList1);
//                adapter = new Adapter(productList, getApplication());
//                recyclerView.setAdapter(adapter);
//                progressDialog.hide();
//            });
//            writeOnDB.execute(productWithMerchantsList);
        });
        retrofit_cont.get_the_list();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return new CursorLoader(getApplicationContext() , CONTENT_URI , PRODUCT_TABLE_COLUMNS , null , null , null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        List<Product> productList = new ArrayList<>();

        while (data.moveToNext()) {
            Product product = new Product();
            product.setId(data.getString(data.getColumnIndex(PRO_ID)));
            product.setName((data.getString(data.getColumnIndex(PRO_NAME))));
            product.setDescription(data.getString(data.getColumnIndex(PRO_DESCRIPTION)));
            product.setPrice(data.getString(data.getColumnIndex(PRO_PRICE)));
            product.setUnit_price(data.getString(data.getColumnIndex(PRO_UNIT_PRICE)));
            product.setProduct_type_id(data.getString(data.getColumnIndex(PRO_PRODUCT_TYPE_ID)));
            product.setDescription(data.getString(data.getColumnIndex(PRO_DESCRIPTION)));
            product.setImage_url(data.getString(data.getColumnIndex(PRO_IMAGE_URL)));
            product.setShopping_list_item_id(data.getString(data.getColumnIndex(PRO_SHOPPING_LIST_ITEM_ID)));
            product.setShopping_cart_item_id(data.getString(data.getColumnIndex(PRO_SHOPPING_CART_ITEM_ID)));

            productList.add(product);
        }

        this.productList = new ArrayList<>(productList);
        adapter = new Adapter(productList , this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public boolean insertProduct(List<ProductWithMerchants> productWithMerchants) {
        helper.refreshTables();
        for(int i = 0 ; i < productWithMerchants.size() ; i++)
        {
            Product product = productWithMerchants.get(i).getProduct();
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

            getContentResolver().insert(CONTENT_URI , productDetails);
        }
        return true;
    }

}
