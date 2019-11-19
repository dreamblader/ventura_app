package com.masterus.ventura_shop.models.datatypes;

import java.io.Serializable;

public class Category implements Serializable
{
    int id;
    String name;

    //GETs
    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
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
}
