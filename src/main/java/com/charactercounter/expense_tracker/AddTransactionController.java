package com.charactercounter.expense_tracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class AddTransactionController {

    @FXML
    private TextField amountField;

    @FXML
    private TextField dateField;

    @FXML
    private ChoiceBox<String> typeChoice;

    @FXML
    private TextField categoryField;

    @FXML
    private Button saveBtn;

    @FXML
    protected void onSaveClick() throws IOException {
        System.out.println("Transaction saved:");
        System.out.println("Amount: " + amountField.getText());
        System.out.println("Date: " + dateField.getText());
        System.out.println("Type: " + typeChoice.getValue());
        System.out.println("Category: " + categoryField.getText());

        // After saving, return to MainView
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Expense Tracker Dashboard");
        stage.show();
    }
}
