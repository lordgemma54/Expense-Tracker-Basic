package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TransactionCellController {

    @FXML
    private Label transactionCellItemLabel, transactionCellAmountLabel;

    @FXML
    private Button transactionCellEditButton, transactionCellDeleteButton;

    @FXML
    private HBox transactionCell;

    private Transaction transaction;

    public void initialize(){}

    public void setTransactionCellItemLabel(String item) {
        transactionCellItemLabel.textProperty().set(transaction.getItem());
    }

    public void setTransactionCellAmountLabel(double amount) {
        transactionCellAmountLabel.textProperty().set("$" + String.valueOf(transaction.getAmount()));
    }

//      handle all styling here
//      call the edit/create dialog here
//    tell the transactionsListController to remove the cell when delete is pressed

    public void setTransaction (Transaction t) {
        this.transaction = t;
        setTransactionCellItemLabel(t.getItem());
        setTransactionCellAmountLabel(t.getAmount());
        transactionCellEditButton = new Button();
        transactionCellDeleteButton = new Button();
    }
}
