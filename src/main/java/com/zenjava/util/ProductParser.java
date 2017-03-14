package com.zenjava.util;

import com.zenjava.model.Product;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 13/03/2017.
 */

public class ProductParser {

    private ArrayList<Product> products;

    private void parser(String path) {
        products = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(getClass().getClassLoader().getResource(path).getFile()));
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                products.add(new Product(jsonObject.get("name").toString(), jsonObject.get("desc").toString(),
                       jsonObject.get("prix").toString(), jsonObject.get("image").toString(), jsonObject.get("category").toString()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() throws IOException {
        parser("product/products.json");
        return products;
    }

    public List<String> getCategories() throws IOException {
        List<String> categories = new ArrayList<>();
        for (Product product : getProducts()) {
            if (!categories.contains(product.getCategory()))
                categories.add(product.getCategory());
        }
        return categories;
    }
}
