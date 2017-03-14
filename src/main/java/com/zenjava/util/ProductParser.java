package com.zenjava.util;

import com.zenjava.model.Product;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

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
                       jsonObject.get("prix").toString(), null, jsonObject.get("category").toString()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Product> getProducts() throws IOException {
        parser("product/products.json");
        return products;
    }
}
