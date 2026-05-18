package Controllers;

import Classes.Transaction.Transaction;
import Classes.Transaction.TransactionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class deleteTransController {

    @FXML private TextField transactionIdField;
    @FXML private Label transactionInfoLabel;
    @FXML private Label messageLabel;
    @FXML private Button deleteBtn;
    @FXML private Button backBtn;

    @FXML
    protected void onLookupClick() {
        String idText = transactionIdField.getText().trim();

        if (idText.isEmpty()) {
            messageLabel.setText("Please enter a Transaction ID.");
            transactionInfoLabel.setText("");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            messageLabel.setText("Transaction ID must be a number.");
            transactionInfoLabel.setText("");
            return;
        }

        Transaction transaction = TransactionManager.findById(id);
        if (transaction == null) {
            messageLabel.setText("No transaction found with ID " + id + ".");
            transactionInfoLabel.setText("");
            return;
        }

        messageLabel.setText("");
        transactionInfoLabel.setText(
                "ID: " + transaction.getTransactionId() + "\n" +
                        "Amount: ₱" + transaction.getAmount() + "\n" +
                        "Type: " + transaction.getType() + "\n" +
                        "Date: " + transaction.getDate() + "\n" +
                        "Description: " + transaction.getDescription()
        );
    }

    @FXML
    protected void onDeleteClick() throws IOException {
        String idText = transactionIdField.getText().trim();

        if (idText.isEmpty()) {
            messageLabel.setText("Please enter a Transaction ID.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            messageLabel.setText("Transaction ID must be a number.");
            return;
        }

        boolean success = TransactionManager.deleteTransaction(id);
        if (!success) {
            messageLabel.setText("Transaction not found.");
            return;
        }

        System.out.println("Transaction deleted: ID " + id);
        goToMain();
    }

    @FXML
    protected void onBackClick() throws IOException {
        goToMain();
    }

    private void goToMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Expense Tracker Dashboard");
        stage.show();
    }
}