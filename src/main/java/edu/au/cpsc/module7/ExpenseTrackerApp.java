package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpenseTrackerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExpenseTrackerApp.class.getResource("expense-tracker-app.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rahul Venkatesh's Expense Tracker");
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.show();
    }
}
