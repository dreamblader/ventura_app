package com.masterus.ventura_shop.controllers;

import com.masterus.ventura_shop.models.APIRequester;
import com.masterus.ventura_shop.models.datatypes.Product;
import com.masterus.ventura_shop.models.factories.ProductFactory;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/***
 * Load all View Products based on the Search bar text
 */
public class ProductLoader
{
    private static final String TAG = "ProductLoader ";
    private static final String API = "https://shopfacil.vtexcommercestable.com.br/api/catalog_system/pub/products/search/";

    public List<Product> load(String search)
    {
        List<Product> result = new ArrayList<>();
        String requestLink = API+search;
        APIRequester requester = new APIRequester();
        ProductFactory factory = new ProductFactory();

        try
        {
            JSONArray response = requester.execute(requestLink, "GET").get();
            result = factory.createMultipleProducts(response);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
