

package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private ListView<String> toPayList;

    @FXML
    private Label weekBudgetLabel;

    @FXML
    private Label monthBudgetLabel;

    @FXML
    private Label weekSpentLabel;

    @FXML
    private Label monthSpentLabel;

    @FXML
    private Label incomeLabel;

    @FXML
    private ListView<String> topSpendingList;

    @FXML
    private PieChart spendingChart;

    @FXML
    private Button addTransactionFab;

    @FXML
    private Button profileBtn;

    @FXML
    public void initialize() {
        toPayList.getItems().addAll("Electricity bill", "Borrowed money from friend");

        weekBudgetLabel.setText("Week: PHP 300 / PHP 500");
        monthBudgetLabel.setText("Month: PHP 1200 / PHP 3000");

        weekSpentLabel.setText("Week: PHP 300");
        monthSpentLabel.setText("Month: PHP 700");

        incomeLabel.setText("PHP 500");

        topSpendingList.getItems().addAll("Food", "Leisure", "Necessities", "Transport");

        spendingChart.getData().addAll(
                new PieChart.Data("Food", 40),
                new PieChart.Data("Leisure", 25),
                new PieChart.Data("Necessities", 20),
                new PieChart.Data("Transport", 15)
        );
    }

    @FXML
    private void onAddTransactionClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/AddTransactionView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) addTransactionFab.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add Transaction");
        stage.show();
    }

    @FXML
    private void onProfileClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProfileView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) profileBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }
}
