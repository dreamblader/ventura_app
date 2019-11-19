package com.masterus.ventura_shop.views;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.masterus.ventura_shop.R;
import com.masterus.ventura_shop.controllers.ProductLoader;
import com.masterus.ventura_shop.models.datatypes.Product;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SearchActivity extends FragmentActivity
{
    private final static String TAG = "SearchActivity ";

    ProductLoader loader;
    EditText searchText;
    ImageButton searchButton;
    boolean noSearchYet = true;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        loader = new ProductLoader();
        renderFragments(loader.load(""));

        searchText = findViewById(R.id.search_bar);
        searchText.setOnFocusChangeListener(searchListener);

        searchButton = findViewById(R.id.search_btn);
        searchButton.setOnClickListener(searchButtonListener);
    }

    //Render
    private void renderFragments(List<Product> list)
    {
        FragmentManager manager = getSupportFragmentManager();
        LinearLayout container = findViewById(R.id.products_container);

        FragmentTransaction transaction = manager.beginTransaction();

        clearFragments(container);

        for(Product product : list)
        {
            Fragment fragment = new ProductFragment();
            //FrameLayout frame = new FrameLayout(this);
            Bundle bundle = new Bundle();
            bundle.putSerializable("product",product);
            fragment.setArguments(bundle);

            transaction.add(R.id.products_container,fragment);
            Log.d(TAG, "fragment ID: "+fragment.getId()+" started");

        }

        transaction.commit();


    }

    private void clearFragments(LinearLayout container)
    {
        for (Fragment fragment : getSupportFragmentManager().getFragments())
        {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }

        container.removeAllViews();
    }

    //Listeners
    View.OnClickListener searchButtonListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String search = searchText.getText().toString();
            renderFragments(loader.load(search));
        }
    };


    View.OnFocusChangeListener searchListener = new View.OnFocusChangeListener()
    {
        @Override
        public void onFocusChange(View v, boolean hasFocus)
        {
            EditText e = (EditText) v;
            String text = e.getText().toString();

            if(hasFocus && noSearchYet)
            {
                e.getText().clear();
                e.setTextColor(ContextCompat.getColor(context, R.color.defaultBlack));
                noSearchYet = false;
            }
            else if(!hasFocus && text.isEmpty())
            {
                e.setText(R.string.inside_search);
                e.setTextColor(ContextCompat.getColor(context, R.color.fadedLetter));
                noSearchYet = true;
            }
        }
    };
}


