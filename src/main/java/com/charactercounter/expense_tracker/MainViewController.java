package com.charactercounter.expense_tracker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button addTransactionBtn;

    @FXML
    private Button viewReportsBtn;

    @FXML
    private TableView<?> transactionTable;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    protected void onAddTransactionClick() throws IOException {
        System.out.println("Add Transaction button clicked!");

        // Load AddItemView.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTransactionView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Get current stage from button
        Stage stage = (Stage) addTransactionBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add Transaction");
        stage.show();
    }

    @FXML
    protected void onViewReportsClick() throws IOException {
        System.out.println("View Reports button clicked!");

        // Placeholder: load ReportsView.fxml when you create it
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReportsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) viewReportsBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.show();
    }
}
