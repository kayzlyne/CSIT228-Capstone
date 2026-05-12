package Controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainViewController {

    @FXML private ListView<String> toPayList;
    @FXML private Label weekBudgetLabel;
    @FXML private Label monthBudgetLabel;
    @FXML private Label weekSpentLabel;
    @FXML private Label monthSpentLabel;
    @FXML private Label incomeLabel;
    @FXML private ListView<String> topSpendingList;
    @FXML private PieChart spendingChart;
    @FXML private Button addTransactionFab;

    @FXML
    public void initialize() {
        // Mock data for demonstration
        toPayList.getItems().addAll("Electricity bill", "Borrowed money from friend");

        weekBudgetLabel.setText("Week: ₱300 / ₱500");
        monthBudgetLabel.setText("Month: ₱1200 / ₱3000");

        weekSpentLabel.setText("Week: ₱300");
        monthSpentLabel.setText("Month: ₱700");

        incomeLabel.setText("₱500");

        topSpendingList.getItems().addAll("Food", "Leisure", "Necessities", "Transport");

        spendingChart.getData().addAll(
                new PieChart.Data("Food", 40),
                new PieChart.Data("Leisure", 25),
                new PieChart.Data("Necessities", 20),
                new PieChart.Data("Transport", 15)
        );
    }

    @FXML
    private void onAddTransactionClick() {
        System.out.println("Floating + button clicked!");
        // Load AddTransactionView.fxml or open a dialog
    }

}
