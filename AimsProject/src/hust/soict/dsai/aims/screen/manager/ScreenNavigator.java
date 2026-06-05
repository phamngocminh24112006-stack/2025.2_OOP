package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ScreenNavigator {

    public static void switchScene(ActionEvent event, String fxmlPath, Cart cart, Store store) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenNavigator.class.getResource(fxmlPath));
            loader.setControllerFactory(type -> {
                try {
                    return type.getConstructor(Cart.class, Store.class).newInstance(cart, store);
                } catch (Exception e) {
                    throw new RuntimeException("Controller thiếu Constructor(Cart, Store): " + type.getName(), e);
                }
            });

            Parent root = loader.load();
            Stage stage = null;
            Object source = event.getSource();

            if (source instanceof Node) {
                stage = (Stage) ((Node) source).getScene().getWindow();
            } else if (source instanceof MenuItem) {
                stage = (Stage) ((MenuItem) source).getParentPopup().getOwnerWindow();
            }

            if (stage != null) {
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}