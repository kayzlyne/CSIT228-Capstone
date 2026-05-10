package com.example.expensetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpenseTrackerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                ExpenseTrackerApplication.class.getResource("expense-tracker-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 1180, 820);
        scene.getStylesheets().add(
                ExpenseTrackerApplication.class.getResource("expense-tracker.css").toExternalForm()
        );

        stage.setTitle("Expense Tracker");
        stage.setMinWidth(1020);
        stage.setMinHeight(720);
        stage.setScene(scene);
        stage.show();
    }
}
