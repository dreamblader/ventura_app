package com.masterus.ventura_shop.models.datatypes;

import java.io.Serializable;

public class Seller implements Serializable
{
    private String id;
    private String name;
    private double price;
    private double listPrice;
    private double rewardValue;
    private int quantity;
    private double tax;

    //GETs
    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public double getPrice(){ return  this.price;}

    public double getListPrice(){ return  this.listPrice;}

    public double getRewardValue(){ return  this.rewardValue;}

    public int getQuantity(){ return  this.quantity;}

    public double getTax(){ return  this.tax;}

    //SETs
    public void setId(String value)
    {
        this.id = value;
    }

    public void setName(String value)
    {
        this.name = value;
    }

    public void setPrice(double value){ this.price = value;}

    public void setListPrice(double value){ this.listPrice= value;}

    public void setRewardValue(double value){ this.rewardValue = value;}

    public void setQuantity(int value){ this.quantity= value;}

    public void setTax(double value){ this.tax = value;}


}
