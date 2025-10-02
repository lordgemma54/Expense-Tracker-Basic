package edu.au.cpsc.module7.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class ExpenseTrackerAppController {
    @FXML
    private Label currentBalanceLabel, totalIncomeLabel, totalExpensesLabel;

    @FXML
    private Label itemLabel, amountLabel;

    @FXML
    private Label itemDetailView, amountDetailView, categoryDetailView, noteDetailView;

    @FXML
    private Label itemInfoDetail, amountInfoDetail, categoryInfoDetail, noteInfoDetail;

    @FXML
    private Button editButton, deleteButton, exportButton, newButton;

    @FXML
    private MenuItem file, edit;

//    @FXML


//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}
