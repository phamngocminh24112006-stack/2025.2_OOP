package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.addItem.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.addItem.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.addItem.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId, radioBtnFilterTitle;
    @FXML private TableView<Media> tblView;
    @FXML private TableColumn<Media, String> colMediaTitle, colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnRemove, btnPlay, btnPlaceOrder;
    @FXML private Label lblTotalCost;

    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblView.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                btnRemove.setVisible(true);
                btnPlay.setVisible(newVal instanceof Playable);
            }
        });

        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML void btnRemovePressed(ActionEvent event) {
        Media m = tblView.getSelectionModel().getSelectedItem();
        if (m != null) cart.removeMedia(m);
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media m = tblView.getSelectionModel().getSelectedItem();
        if (m instanceof Playable) {
            try {
                ((Playable) m).play();
            } catch (PlayerException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Playback Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML void btnPlaceOrderPressed(ActionEvent event) {
        cart.getItemsOrdered().clear();
        lblTotalCost.setText("0.00 $");
    }

    @FXML void addBookPressed(ActionEvent e) { openAddScreen("Add Book", AddBookToStoreScreen.class); }
    @FXML void addCdPressed(ActionEvent e) { openAddScreen("Add CD", AddCompactDiscToStoreScreen.class); }
    @FXML void addDvdPressed(ActionEvent e) { openAddScreen("Add DVD", AddDigitalVideoDiscToStoreScreen.class); }

    private void openAddScreen(String title, Class<?> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/designFXML/addItem.fxml"));
            loader.setControllerFactory(type -> {
                try {
                    return controllerClass.getConstructor(Store.class, Cart.class).newInstance(this.store, this.cart);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            });

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML void viewStorePressed(ActionEvent e) {
        ScreenNavigator.switchScene(e, "/hust/soict/dsai/aims/screen/designFXML/Store.fxml", this.cart, this.store);
    }
    @FXML void viewCartPressed(ActionEvent e) {
        ScreenNavigator.switchScene(e, "/hust/soict/dsai/aims/screen/designFXML/Cart.fxml", this.cart, this.store);
    }
}