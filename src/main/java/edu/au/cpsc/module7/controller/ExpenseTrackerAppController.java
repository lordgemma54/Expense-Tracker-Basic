package edu.au.cpsc.module7.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ExpenseTrackerAppController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
