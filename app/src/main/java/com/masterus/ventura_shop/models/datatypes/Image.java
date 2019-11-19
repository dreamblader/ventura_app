package com.masterus.ventura_shop.models.datatypes;

import android.util.Log;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class Image implements Serializable
{
    private static final String TAG = "Image ";

    private int id;
    private URL url;
    private String text;
    private String label;

    //GETs
    public int getId()
    {
        return this.id;
    }

    public URL getURL()
    {
        return this.url;
    }

    public String getText()
    {
        return this.text;
    }

    public  String getLabel()
    {
        return this.label;
    }

    //SETs
    public void setId(int value)
    {
        this.id = value;
    }

    public void setURL(URL value)
    {
        this.url = value;
    }

    public void setURL(String value)
    {
        try
        {
            URL newURL = new URL(value);
            setURL(newURL);
        }
        catch (MalformedURLException e)
        {
            System.out.println("String not in URL format");
            Log.d(TAG, "String not in URL format");

        }

    }

    public void setText(String value)
    {
        this.text = value;
    }

    public  void setLabel(String value)
    {
        this.label = value;
    }

    /*
    "imageId":"36185921",
            "imageLabel":null,
            "imageTag":"<img src=\"~/arquivos/ids/36185921-#width#-#height#/6291819_1.jpg?v=637007173687300000\" width=\"#width#\" height=\"#height#\" alt=\"6291819_1\" id=\"\" />",
            "imageUrl":"https://shopfacil.vteximg.com.br/arquivos/ids/36185921/6291819_1.jpg?v=637007173687300000",
            "imageText":"6291819_1"

     */
}
