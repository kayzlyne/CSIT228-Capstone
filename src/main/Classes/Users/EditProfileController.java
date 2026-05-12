package Users;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditProfileController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        User currentUser = User.getCurrentUser();

        if (currentUser == null) {
            messageLabel.setText("No logged in user.");
            return;
        }

        nameField.setText(currentUser.getName());
        emailField.setText(currentUser.getEmail());
    }

    @FXML
    private void onSaveClick() throws IOException {
        User currentUser = User.getCurrentUser();

        if (currentUser == null) {
            messageLabel.setText("No logged in user.");
            return;
        }

        try {
            currentUser.updateProfile(nameField.getText(), emailField.getText(), passwordField.getText());
            openScene("/ProfileView.fxml", "Profile");
        } catch (IllegalArgumentException exception) {
            messageLabel.setText(exception.getMessage());
        }
    }

    @FXML
    private void onCancelClick() throws IOException {
        openScene("/ProfileView.fxml", "Profile");
    }

    private void openScene(String resourceName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourceName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
