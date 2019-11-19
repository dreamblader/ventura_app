package com.masterus.ventura_shop.controllers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.masterus.ventura_shop.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import androidx.fragment.app.FragmentActivity;

public class ImageLoader extends AsyncTask <URL, Void, Bitmap>
{
    ImageView view;
    int height;
    int width;

    public ImageLoader(ImageView view)
    {
        this.view = view;
    }

    @Override
    protected Bitmap doInBackground(URL... urls)
    {
       URL url =urls[0];
       Bitmap img = null;

       try(InputStream input = url.openStream())
       {
           img = BitmapFactory.decodeStream(input);
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }

       return img;
    }

    @Override
    protected void onPostExecute(Bitmap result)
    {
        view.setImageBitmap(result);
    }
}
