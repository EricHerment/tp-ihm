package com.zenjava.util;

import com.zenjava.model.Product;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;



/**
 * Returns the list of cell
 */
public class ProductCellFactory implements Callback<ListView<Product>, ListCell<Product>>{

    @Override
    public ListCell<Product> call(ListView<Product> param) {
        return new ProductCell();
    }
}
