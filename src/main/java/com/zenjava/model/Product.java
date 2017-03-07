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
    private IntegerProperty price;
    private Image image;
    private String category;

    public Product(String name, String description, IntegerProperty price, Image image, String category) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.price = price;
        this.image = image;
        this.category = category;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }
}
