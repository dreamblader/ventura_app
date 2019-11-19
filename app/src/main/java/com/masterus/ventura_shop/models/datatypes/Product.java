package com.masterus.ventura_shop.models.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable
{
    private int id;
    private String name;
    private Brand brand;
    //String metaTagdescription;
    private String description;
    //private long productReference;
    private int categoryId;
    private List<Category> categories;
    private List<Item> items;

    public Product()
    {
        categories = new ArrayList<>();
        items = new ArrayList<>();
    }

    //GETS
    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }
    public Brand getBrand()
    {
        return this.brand;
    }

    public String getDescription()
    {
        return this.description;
    }

    public int getCategoryId()
    {
        return this.categoryId;
    }

    public List<Category> getCategories()
    {
        return this.categories;
    }

    public List<Item> getItems ()
    {
        return this.items;
    }

    //By ID GETs
    public Category getCategorieById(int searchedId)
    {
        for(Category categorie : categories)
        {
            int categorieId = categorie.getId();

            if(searchedId == categorieId)
            {
                return categorie;
            }
        }

        return null;
    }

    public Item getItemById(int searchedId)
    {
        for(Item item : items)
        {
            int sellerId = item.getId();

            if(searchedId == sellerId)
            {
                return item;
            }
        }

        return null;
    }

    //SETS

    public void setId(int value)
    {
        this.id = value;
    }

    public void setName(String value)
    {
        this.name = value;
    }
    public void setBrand(Brand value)
    {
       this.brand = value;
    }

    public void setDescription(String  value)
    {
        this.description = value;
    }

    public void setCategoryId(int value)
    {
        this.categoryId = value;
    }

    public void setCategories(List<Category> value)
    {
        this.categories = value;
    }

    public void setItems(List<Item> value)
    {
        this.items = value;
    }

    //LISTS ADDs
    public void addCategorie(Category value)
    {
        this.categories.add(value);
    }

    public void addItem (Item value)
    {
        this.items.add(value);
    }


}
