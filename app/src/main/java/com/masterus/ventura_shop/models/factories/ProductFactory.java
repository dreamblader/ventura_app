package com.masterus.ventura_shop.models.factories;

import com.masterus.ventura_shop.models.datatypes.Brand;
import com.masterus.ventura_shop.models.datatypes.Category;
import com.masterus.ventura_shop.models.datatypes.Item;
import com.masterus.ventura_shop.models.datatypes.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory
{
    public List<Product> createMultipleProducts(JSONArray array)
    {
        List<Product> resultList = new ArrayList<>();

        try {
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject object = array.getJSONObject(i);
                Product product = createProductFromJson(object);
                resultList.add(product);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        return resultList;
    }

    public Product createProductFromJson (JSONObject object)
    {
        Product result = new Product();
        ItemFactory factory = new ItemFactory();

        try
        {
            int id = object.getInt("productId");
            String name = object.getString("productName");
            Brand brand = createBrandForProduct(object.getInt("brandId"), object.getString("brand"),object.getString("brandImageUrl"));
            String description = object.getString("description");
            int categoryId = object.getInt("categoryId");

            JSONArray categoriesId = object.getJSONArray("categoriesIds");
            JSONArray categoriesName = object.getJSONArray("categories");

            List<Category> categories = createCategoriesListFromJson(categoriesId, categoriesName);
            List<Item> items = factory.createMultipleItems(object.getJSONArray("items"));

            //Polish Strings
            name = htmlBreak(name);
            description = htmlBreak(description);

            //constructor
            result.setId(id);
            result.setName(name);
            result.setBrand(brand);
            result.setDescription(description);
            result.setCategoryId(categoryId);
            result.setCategories(categories);
            result.setItems(items);
            //result.setSellers(sellers);


        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

         return result;
    }

    private Brand createBrandForProduct(int id, String name, String imgURL)
    {
        Brand result = new Brand();
        result.setId(id);
        result.setName(name);
        result.setImgURL(imgURL);

        return result;
    }

    private List<Category> createCategoriesListFromJson(JSONArray arrayId, JSONArray arrayName) throws JSONException
    {
        List<Category> resultList = new ArrayList<>();

        String idString = arrayId.getString(0);
        String[] ids = idString.split("/");

        String nameString = arrayName.getString(0);
        String[] names = nameString.split("/");

        int length = Math.min(ids.length, names.length); // They're supposed to be the same length. HOWEVER, if somehow we got different lengths this take the minimum one to prevent IndexOutBounds

        for(int i=0; i<length; i++)
        {
            if(!ids[i].isEmpty() && !names[i].isEmpty())
            {
                Category category = new Category();
                category.setId(Integer.valueOf(ids[i]));
                category.setName(names[i]);

                resultList.add(category);
            }
        }

        return resultList;
    }


    private String htmlBreak(String value)
    {
        value = value.replace("&quot;", "\"");
        value = value.replace("<br>", "\n");
        value = value.replaceAll("<.[^>]*>", "");
        return value;
    }

    /*
    public Boolean checkCategorieExistence(List<Category> list, int comparator)
    {
        if(list.size()<1)// comparator is not in the List because List is empty
        {
            return false;
        }
        else
        {
            for(Category categorie : list)
            {
                int id = categorie.getId();

                if(id == comparator)
                {
                    return true;
                }
            }

            return false;
        }
    }

     */
}
