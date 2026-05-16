package Classes.Budget;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BudgetController {

    @FXML
    private TextField allocationAmountField;

    @FXML
    private Button saveBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField startDateField;

    @FXML
    private TextField endDateField;

    @FXML
    protected void handleSave() throws IOException {
        String input = allocationAmountField.getText().replace("₱", "").trim();
        String start = startDateField.getText().trim();
        String end = endDateField.getText().trim();

        if (input.isEmpty() || start.isEmpty() || end.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        double amount = Double.parseDouble(input);
        System.out.println("Budget saved:");
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        System.out.println("Amount Limit: ₱" + amount);

        goToMain();
    }

    @FXML
    protected void handleCancel() throws IOException {
        goToMain();
    }

    private void goToMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) allocationAmountField.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Expense Tracker Dashboard");
        stage.show();
    }
}