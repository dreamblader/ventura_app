package com.masterus.ventura_shop.models.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable
{
    int id;
    String name;
    String nameComplete;
    String complementName;
    String ean;
    String un;
    double unMultiplier;
    boolean isKit;
    List<Image> images;
    List<Seller> sellers;

    public Item()
    {
        images = new ArrayList<>();
        sellers = new ArrayList<>();
    }

    //GETS
    public int getId(){ return this.id;}
    public String getName()
    {
        return this.name;
    }
    public String getNameComplete(){ return this.nameComplete; }
    public String getComplementName()
    {
        return this.complementName;
    }
    public String getEAN(){ return this.ean;}
    public String getUn(){return this.un;}
    public  double getUnMultiplier(){return this.unMultiplier;}
    public  boolean getIsKit(){return this.isKit;}
    public List<Image> getImages()
    {
        return this.images;
    }
    public List<Seller> getSellers ()
    {
        return this.sellers;
    }

    //By ID GETs
    public Image getImageById(int searchedId)
    {
        for(Image image : images)
        {
            int imageId = image.getId();

            if(searchedId == imageId)
            {
                return image;
            }
        }

        return null;
    }

    public Seller getSellerById(String searchedId)
    {
        for(Seller seller : sellers)
        {
            String sellerId = seller.getId();

            if(searchedId.equals(sellerId))
            {
                return seller;
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
    public void setNameComplete(String value){ this.nameComplete = value; }
    public void setComplementName(String value)
    {
        this.complementName = value;
    }
    public void setEAN(String value){ this.ean = value;}
    public void setUn(String value){ this.un = value;}
    public void setUnMultiplier(double value){ this.unMultiplier = value;}
    public void setIsKit(boolean value){ this.isKit = value;}
    public void setImages(List<Image> value)
    {
        this.images = value;
    }
    public void setSellers (List<Seller> value)
    {
        this.sellers = value;
    }


    //LISTS ADDs
    public void addImage (Image value)
    {
        this.images.add(value);
    }
    public void addSeller (Seller value)
    {
        this.sellers.add(value);
    }

}

/*

JSON SAMPLE:

            "itemId":"6291819",
            "name":"X Pre Workout 450g Pink Lemonade Atlhetica Nutrition",
            "nameComplete":"X Pre Workout 450g Atlhetica Nutrition X Pre Workout 450g Pink Lemonade Atlhetica Nutrition",
            "complementName":"",
            "ean":"7899621108416",
            "referenceId":[
               {
                  "Key":"RefId",
                  "Value":"83B.01"
               }
            ],
            "measurementUnit":"un",
            "unitMultiplier":1.0000,
            "modalType":null,
            "isKit":false,
            "images":[
               {
                  "imageId":"36185921",
                  "imageLabel":null,
                  "imageTag":"<img src=\"~/arquivos/ids/36185921-#width#-#height#/6291819_1.jpg?v=637007173687300000\" width=\"#width#\" height=\"#height#\" alt=\"6291819_1\" id=\"\" />",
                  "imageUrl":"https://shopfacil.vteximg.com.br/arquivos/ids/36185921/6291819_1.jpg?v=637007173687300000",
                  "imageText":"6291819_1"
               }
            ],
            "sellers":[
 */
