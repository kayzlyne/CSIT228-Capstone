package Users;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        User currentUser = User.getCurrentUser();

        if (currentUser == null) {
            messageLabel.setText("No logged in user.");
            return;
        }

        nameLabel.setText(currentUser.getName());
        emailLabel.setText(currentUser.getEmail());
    }

    @FXML
    private void onUpdateProfileClick() throws IOException {
        openScene("/EditProfileView.fxml", "Update Profile");
    }

    @FXML
    private void onLogoutClick() throws IOException {
        User.logout();
        openScene("/LoginView.fxml", "Expense Tracker");
    }

    @FXML
    private void onBackClick() throws IOException {
        openScene("/MainView.fxml", "Expense Tracker Dashboard");
    }

    private void openScene(String resourceName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourceName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) nameLabel.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
