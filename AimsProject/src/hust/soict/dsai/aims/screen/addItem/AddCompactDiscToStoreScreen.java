package hust.soict.dsai.aims.screen.addItem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store, Cart cart) { super(store, cart); }

    @FXML
    public void initialize() {
        lblHeader.setText("Add New CD");
        lblExtra.setText("Artist:");
    }

    @Override
    protected void processAdd() {
        CompactDisc cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(), "Director", Float.parseFloat(tfCost.getText()), tfExtra.getText());
        store.addMedia(cd);
        cart.addMedia(cd);
    }
}