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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class addTransController {

    @FXML private TextField amountField;
    @FXML private TextField dateField;
    @FXML private TextField descriptionField;
    @FXML private ChoiceBox<String> typeChoice;
    @FXML private Label messageLabel;
    @FXML private Button saveBtn;
    @FXML private Button backBtn;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @FXML
    public void initialize() {
        typeChoice.getItems().setAll("Income", "Expense");
        typeChoice.setValue("Expense");

        // Auto-fill today's date
        dateField.setText(LocalDate.now().format(DATE_FORMAT));
    }

    @FXML
    protected void onSaveClick() throws IOException {
        String amountText = amountField.getText().trim();
        String dateText   = dateField.getText().trim();
        String typeText   = typeChoice.getValue();
        String desc       = descriptionField.getText().trim();

        if (amountText.isEmpty() || dateText.isEmpty() || desc.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
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

        LocalDate date;
        try {
            date = LocalDate.parse(dateText, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            messageLabel.setText("Date format must be yyyy-MM-dd (e.g. 2025-05-16).");
            return;
        }

        Transaction.Type type = typeText.equals("Income") ? Transaction.Type.INCOME : Transaction.Type.EXPENSE;

        TransactionManager.addTransaction(amount, date, type, 0, desc);
        System.out.println("Transaction added: ₱" + amount + " | " + type + " | " + date);

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