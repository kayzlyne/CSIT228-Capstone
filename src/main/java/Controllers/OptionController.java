package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OptionController {

    private MainViewController mainViewController;

    @FXML
    private Button viewReportsBtn;

    @FXML
    private Button categoryBtn;

    @FXML
    private Button setBudgetBtn;

    @FXML
    private Button addTransactionBtn;

    public void setMainViewController(MainViewController controller) {
        this.mainViewController = controller;
    }

    @FXML
    private void onAddTransactionClick() throws IOException {
        mainViewController.closeBudgetSheet();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddTransactionView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) addTransactionBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add Transaction");
        stage.show();
    }

    @FXML
    private void onSetBudgetClick() throws IOException {
        mainViewController.closeBudgetSheet();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BudgetView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) setBudgetBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Set Budget");
        stage.show();
    }

    @FXML
    private void onCategoryClick() throws IOException {
        mainViewController.closeBudgetSheet();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Category.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) categoryBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Category");
        stage.show();
    }

    @FXML
    private void onViewReportsClick() {
        System.out.println("View Reports — coming soon!");
    }
}