package com.masterus.ventura_shop.models.factories;

import com.masterus.ventura_shop.models.datatypes.Image;
import com.masterus.ventura_shop.models.datatypes.Item;
import com.masterus.ventura_shop.models.datatypes.Seller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory
{
    public List<Item> createMultipleItems(JSONArray array)
    {
        List<Item> resultList = new ArrayList<>();

        try {
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject object = array.getJSONObject(i);
                Item item = createItemFromJson(object);
                resultList.add(item);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return resultList;
    }

    public Item createItemFromJson (JSONObject object)
    {
        Item result = new Item();

        try
        {
            int id = object.getInt("itemId");
            String name = object.getString("name");
            String nameComplete = object.getString("nameComplete");
            String complementName = object.getString("complementName");
            String ean = object.getString("ean");
            String un = object.getString("measurementUnit");
            double unMultiplier = object.getDouble("unitMultiplier");
            boolean isKit = object.getBoolean("isKit");
            List<Image> images = createImagesListFromJson(object.getJSONArray("images"));
            List<Seller> sellers = createSellersListFromJson(object.getJSONArray("sellers"));

            //constructor
            result.setId(id);
            result.setName(name);
            result.setNameComplete(nameComplete);
            result.setComplementName(complementName);
            result.setEAN(ean);
            result.setUn(un);
            result.setUnMultiplier(unMultiplier);
            result.setIsKit(isKit);
            result.setImages(images);
            result.setSellers(sellers);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }



        return result;
    }


    private List<Image> createImagesListFromJson(JSONArray array) throws JSONException
    {
        List<Image> resultList = new ArrayList<>();

        for(int i=0; i<array.length(); i++)
        {
            JSONObject jsonIMG = array.getJSONObject(i);
            Image image = new Image();
            image.setId(jsonIMG.getInt("imageId"));
            image.setURL(jsonIMG.getString("imageUrl"));
            image.setText(jsonIMG.getString("imageText"));
            image.setLabel(jsonIMG.getString("imageLabel"));


            resultList.add(image);
        }

        return resultList;
    }

    private List<Seller> createSellersListFromJson(JSONArray array) throws JSONException
    {
        List<Seller> resultList = new ArrayList<>();

        for(int i=0; i<array.length(); i++)
        {
            JSONObject jsonSeller = array.getJSONObject(i);
            Seller seller = new Seller();
            seller.setId(jsonSeller.getString("sellerId"));
            seller.setName(jsonSeller.getString("sellerName"));

            JSONObject comertialOffer = jsonSeller.getJSONObject("commertialOffer");

            seller.setPrice(comertialOffer.getDouble("Price"));
            seller.setListPrice(comertialOffer.getDouble("ListPrice"));
            seller.setRewardValue(comertialOffer.getDouble("RewardValue"));
            seller.setQuantity(comertialOffer.getInt("AvailableQuantity"));
            seller.setTax(comertialOffer.getDouble("Tax"));

            resultList.add(seller);
        }

        return resultList;
    }
}
