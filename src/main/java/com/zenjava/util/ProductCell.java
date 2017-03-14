package com.zenjava.util;

import com.zenjava.model.Product;
import javafx.scene.control.ListCell;

/**
 * Represents a cell of the listview
 */
public class ProductCell extends ListCell<Product> {

    @Override
    public void updateItem(Product product, boolean empty) {
            super.updateItem(product, empty);
            String name = "";
            if (product != null && !empty) {
                name = product.getName();
            }
            this.setText(name);
    }

}
