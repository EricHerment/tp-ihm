package com.zenjava.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * Model for the products displayed in the store
 */
public class Product {

    private StringProperty name;
    private StringProperty description;
    private StringProperty price;
    private StringProperty image;
    private String category;

    public Product(String name, String description, String price, String image, String category) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleStringProperty(price);
        this.image = new SimpleStringProperty(image);
        this.category = category;
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }

    public void setImage(String image) {
        this.image.set(image);
    }
}
