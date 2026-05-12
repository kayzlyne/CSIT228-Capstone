package Users;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void onRegisterClick() throws IOException {
        try {
            User.register(nameField.getText(), emailField.getText(), passwordField.getText());
            User.login(emailField.getText(), passwordField.getText());
            openScene("/MainView.fxml", "Expense Tracker Dashboard");
        } catch (IllegalArgumentException exception) {
            messageLabel.setText(exception.getMessage());
        }
    }

    @FXML
    private void onBackToLoginClick() throws IOException {
        openScene("/LoginView.fxml", "Expense Tracker");
    }

    private void openScene(String resourceName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourceName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) emailField.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
