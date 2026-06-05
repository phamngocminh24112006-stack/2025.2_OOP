package hust.soict.dsai.aims.screen.addItem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) { super(store, cart); }

    @FXML
    public void initialize() {
        lblHeader.setText("Add New DVD");
        lblExtra.setText("Director:");
    }

    @Override
    protected void processAdd() {
        DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfExtra.getText(), 0, Float.parseFloat(tfCost.getText()));
        store.addMedia(dvd);
        cart.addMedia(dvd);
    }
}