package com.zenjava.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by eric on 04/03/2017.
 */
public class Product {

    private StringProperty name;
    private StringProperty description;
    private IntegerProperty price;

    public Product(StringProperty name, StringProperty description, IntegerProperty price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }

    public int getPrice() {
        return price.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }


    public void setPrice(int price) {
        this.price.set(price);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public IntegerProperty priceProperty() {
        return price;
    }

}
