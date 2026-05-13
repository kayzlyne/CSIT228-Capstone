

package Controllers;

import Users.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    protected void onLoginClick() throws IOException {
        if (!User.login(emailField.getText(), passwordField.getText())) {
            messageLabel.setText("Invalid email or password.");
            return;
        }

        openScene("/MainView.fxml", "Expense Tracker Dashboard");
    }

    @FXML
    protected void onRegisterClick() throws IOException {
        openScene("/RegisterView.fxml", "Register");
    }

    private void openScene(String resourceName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        fxmlLoader.setLocation(getClass().getResource(resourceName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) emailField.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
