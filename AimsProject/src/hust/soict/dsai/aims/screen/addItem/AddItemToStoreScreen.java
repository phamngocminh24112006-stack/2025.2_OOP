package hust.soict.dsai.aims.screen.addItem;

import hust.soict.dsai.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen {
    @FXML protected TextField tfTitle, tfCategory, tfCost, tfExtra;
    @FXML protected Label lblHeader, lblExtra;
    @FXML protected Button btnAdd;
    protected Store store;
    protected Cart cart;
    public AddItemToStoreScreen(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void btnAddPressed(ActionEvent event) {
        processAdd();
        ((Stage) btnAdd.getScene().getWindow()).close();
    }
    protected abstract void processAdd();
}