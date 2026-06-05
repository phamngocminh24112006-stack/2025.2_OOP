package hust.soict.dsai.aims.screen.addItem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) { super(store, cart); }

    public void initialize() {
        lblHeader.setText("Add New Book");
        lblExtra.setText("Authors:");
    }

    @Override
    protected void processAdd() {
        Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
        book.addAuthor(tfExtra.getText());
        store.addMedia(book);
        cart.addMedia(book);
    }
}