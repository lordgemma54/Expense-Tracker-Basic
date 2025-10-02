package edu.au.cpsc.module7.controller;

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
}
