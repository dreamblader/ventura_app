package com.masterus.ventura_shop.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;
import java.util.Locale;

import androidx.fragment.app.Fragment;

public class ProductFragment extends Fragment
{
    private static final String TAG = "ProductFragment";
    Product product;
    LinearLayout container;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        product = (Product) getArguments().getSerializable("product");
        View view = inflater.inflate(R.layout.product_fragment, container, false);

        TextView title = view.findViewById(R.id.product_title);
        TextView price = view.findViewById(R.id.product_price);
        ImageView img = view.findViewById(R.id.product_img);

        Item item = product.getItems().get(0);
        List<Image> imageList = item.getImages();
        List<Seller> sellerList =item.getSellers();
        Seller seller = sellerList.get(0);

        Image image = imageList.get(0);
        ImageLoader loader = new ImageLoader(img);

        loader.execute(image.getURL());

        Locale ptBr = new Locale("pt", "BR");

        title.setText(product.getName());
        price.setText(NumberFormat.getCurrencyInstance(ptBr).format(seller.getPrice()));


        view.setOnClickListener(fragmentListener);

        return view;
    }

    View.OnClickListener fragmentListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Log.d(TAG,"Fragment Clicked");
            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
            intent.putExtra("product",product);
            getActivity().startActivity(intent);
        }
    };
}
