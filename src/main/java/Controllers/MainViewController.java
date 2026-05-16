package Controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainViewController {

    @FXML private ListView<String> toPayList;
    @FXML private Label weekBudgetLabel;
    @FXML private Label monthBudgetLabel;
    @FXML private Label weekSpentLabel;
    @FXML private Label monthSpentLabel;
    @FXML private Label incomeLabel;
    @FXML private ListView<String> topSpendingList;
    @FXML private PieChart spendingChart;
    @FXML private Button plusButton;
    @FXML private Button profileBtn;
    @FXML private Pane overlay;
    @FXML private VBox budgetSheetContainer;

    private boolean fabOpen = false;

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
    private void onProfileClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProfileView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) profileBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }

    @FXML
    public void onOptionsClick(ActionEvent actionEvent) {
        if (fabOpen) {
            closeBudgetSheet();
        } else {
            openOptionsMenu();
        }
    }

    private void openOptionsMenu() {
        try {
            // FIXED: was /OptionsView.fxml — now matches your actual filename
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/OptionView.fxml"));
            Parent sheetContent = loader.load();

            OptionController optionController = loader.getController();
            optionController.setMainViewController(this);

            budgetSheetContainer.getChildren().setAll(sheetContent);
            budgetSheetContainer.setVisible(true);
            overlay.setVisible(true);

            TranslateTransition slide = new TranslateTransition(Duration.millis(250), budgetSheetContainer);
            slide.setToY(0);
            slide.play();

            plusButton.setText("✕");
            fabOpen = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void closeBudgetSheet() {
        TranslateTransition slide = new TranslateTransition(Duration.millis(250), budgetSheetContainer);
        slide.setToY(500);
        slide.setOnFinished(e -> {
            overlay.setVisible(false);
            budgetSheetContainer.getChildren().clear();
            budgetSheetContainer.setVisible(false);
            plusButton.setText("+");
            fabOpen = false;
        });
        slide.play();
    }
}