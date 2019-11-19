package com.masterus.ventura_shop.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.masterus.ventura_shop.R;
import com.masterus.ventura_shop.controllers.ImageLoader;
import com.masterus.ventura_shop.models.datatypes.Image;
import com.masterus.ventura_shop.models.datatypes.Item;
import com.masterus.ventura_shop.models.datatypes.Product;
import com.masterus.ventura_shop.models.datatypes.Seller;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.core.content.ContextCompat;

public class ProductDetailActivity extends Activity
{
    Product product;
    LinearLayout backBar;
    ImageView display;
    List<Bitmap> displayImages;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);

        displayImages = new ArrayList<>();

        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        item = product.getItems().get(0);
        Seller seller = item.getSellers().get(0);

        backBar = findViewById(R.id.top_title);
        backBar.setOnClickListener(backListener);
        display = findViewById(R.id.banner_img);

        TextView miniTitle = findViewById(R.id.mini_title);
        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        TextView sellerName = findViewById(R.id.seller_info);
        TextView price = findViewById(R.id.price_info);

        Locale ptBr = new Locale("pt", "BR");

        title.setText(product.getName());
        miniTitle.setText(product.getName());
        description.setText(product.getDescription());
        sellerName.setText(seller.getName());
        price.setText(NumberFormat.getCurrencyInstance(ptBr).format(seller.getPrice()));



        createImagesBar();
    }

    protected void createImagesBar()
    {

        LinearLayout bar = findViewById(R.id.img_container);
        List<Image> images = item.getImages();
        boolean noDisplay = true;
        int height = (int) getResources().getDimension(R.dimen.mini_thumbnail_height);
        int width = (int) getResources().getDimension(R.dimen.mini_thumbnail_width);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(width, height);
        imageParams.setMargins(5,5,5,5);

        for(Image image : images)
        {
            ImageButton miniThumbnail = new ImageButton(this);
            ImageLoader loader = new ImageLoader(miniThumbnail);
            miniThumbnail.setLayoutParams(imageParams);
            loader.execute(image.getURL());

            miniThumbnail.setOnClickListener(imageSelectorListener);

            if(noDisplay)
            {
                new ImageLoader(display).execute(image.getURL());
                noDisplay = false;
            }


            bar.addView(miniThumbnail);
        }
    }

    View.OnClickListener backListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            finish();
        }
    };

    View.OnClickListener imageSelectorListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ImageView view = (ImageView) v;
            if(view.getDrawable() != null)
            {
                Bitmap img = ((BitmapDrawable)view.getDrawable()).getBitmap();
                display.setImageBitmap(img);
            }
            //display.getBitmap
            //display.setImageDrawable(view.getDrawable());
        }
    };
}
