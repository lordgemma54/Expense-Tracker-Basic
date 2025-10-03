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
    private Button editButton, deleteButton, exportButton, newButton;

    @FXML
    private MenuItem file, edit;

    @FXML
    private TransactionListController transactionListController;

    @FXML
    private TotalsListController totalsListController;

    @FXML
    private DetailListViewController detailViewController;


    @FXML
    public void initialize() {

            }
}
