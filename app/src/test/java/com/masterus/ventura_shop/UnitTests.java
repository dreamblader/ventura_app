package com.masterus.ventura_shop;

import com.masterus.ventura_shop.models.APIRequester;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests
{
    /*
    @Before
    public  void setUp()
    {
      MockitoAnnotatios.initMocks(this);
    }

     */

    @Test
    public void testRequester()
    {
        APIRequester requester = new APIRequester();
        String testLink = "https://shopfacil.vtexcommercestable.com.br/api/catalog_system/pub/products/search/celular";
        try
        {
            //@Mock
            List<HashMap> testList = requester.execute(testLink, "GET").get();
            assertEquals(4, 2 + 2);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
            fail();
        }
    }
}