package com.masterus.ventura_shop.models.datatypes;

import android.util.Log;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class Brand implements Serializable
{
    private static final String TAG = "Brand ";

    private String name;
    private URL imgURL;
    private int id;

    //GETs
    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public URL getImgURL()
    {
        return this.imgURL;
    }

    //SETs

    public void setId(int value)
    {
        this.id = value;
    }

    public void setName(String value)
    {
        this.name = value;
    }

    public void setImgURL(URL value)
    {
        this.imgURL=value;
    }

    public void setImgURL(String value)
    {
        try
        {
            URL newURL = new URL(value);
            setImgURL(newURL);
        }
        catch (MalformedURLException e)
        {
            System.out.println("String not in URL format");
            Log.d(TAG, "String not in URL format");
        }
    }
}
