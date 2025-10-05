package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class ExpenseTrackerAppController  {
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
    private DetailListViewController detailListViewController;

    private Transaction t1 = new Transaction("boba", "food", "fun with friends", 7.00);


//    do all coordination here - ie. when a row is clicked, tell detailistView to show transactions

    @FXML
    public void initialize() {
    transactionListController.setClickListener(transaction -> {
    detailListViewController.showTransaction(transaction);

});

    transactionListController.setDeletedCallback(transaction -> {
    detailListViewController.clearDetails();
});
//    Transaction t1 = new Transaction("boba", "food", "fun with friends", 7.00);
    Transaction t2 = new Transaction("ipad", "electronics", "for school", 975.50 );
    Transaction t3 = new Transaction("TP", "staples", "for butts", 17.85);
    Transaction t4 = new Transaction("paycheck", "income", "for my sweat", 2000 );
//
    transactionListController.addNewTransactionCell(t1);
        transactionListController.addNewTransactionCell(t2);
        transactionListController.addNewTransactionCell(t3);
        transactionListController.addNewTransactionCell(t4);

    }

    @FXML
    protected void editCreateWindowPopup() throws IOException {
        EditCreateWindowController.showModal(t1, editButton.getScene().getWindow());
    }

}
