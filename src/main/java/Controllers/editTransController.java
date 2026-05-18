package Controllers;

import Classes.Transaction.Transaction;
import Classes.Transaction.TransactionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class editTransController {

    @FXML private TextField transactionIdField;
    @FXML private TextField amountField;
    @FXML private TextField descriptionField;
    @FXML private ChoiceBox<String> typeChoice;
    @FXML private Label messageLabel;
    @FXML private Button saveBtn;
    @FXML private Button backBtn;

    @FXML
    public void initialize() {
        typeChoice.getItems().setAll("Income", "Expense");
        typeChoice.setValue("Expense");
    }

    @FXML
    protected void onSaveClick() throws IOException {
        String idText     = transactionIdField.getText().trim();
        String amountText = amountField.getText().trim();
        String typeText   = typeChoice.getValue();
        String desc       = descriptionField.getText().trim();

        if (idText.isEmpty() || amountText.isEmpty() || desc.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            return;
        }

        int transactionId;
        try {
            transactionId = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            messageLabel.setText("Transaction ID must be a number.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            messageLabel.setText("Amount must be a positive number.");
            return;
        }

        Transaction found = TransactionManager.findById(transactionId);
        if (found == null) {
            messageLabel.setText("Transaction not found.");
            return;
        }

        Transaction.Type type = typeText.equals("Income") ? Transaction.Type.INCOME : Transaction.Type.EXPENSE;

        // Keep original date, only update amount, type, description
        TransactionManager.editTransaction(transactionId, amount, found.getDate(), type, found.getCategoryId(), desc);
        System.out.println("Transaction updated: ID " + transactionId);

        goToMain();
    }

    @FXML
    protected void onBackClick() throws IOException {
        goToMain();
    }

    private void goToMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Expense Tracker Dashboard");
        stage.show();
    }
}