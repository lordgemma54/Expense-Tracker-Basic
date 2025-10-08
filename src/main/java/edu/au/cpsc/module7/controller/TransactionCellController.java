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

//    private static double cellAmount;

    private Transaction transaction;

    private TransactionClickListener clickListener;
    private TransactionDeleteListener deleteListener;
    private EditCreateListener editListener;

//    public double getCellAmount(){
//    cellAmount = Double.parseDouble(transactionCellAmountLabel.getText());
//    return cellAmount;
//    }


    public void setClickListener(TransactionClickListener listener) {
        this.clickListener = listener;
    }

    public void setDeleteListener(TransactionDeleteListener listener) {
        this.deleteListener = listener;
    }

    public void setEditCreateListener(EditCreateListener listener) {
        this.editListener = listener;
    }

    public void setTransactionCellAmountLabel(double amount) {
        String amountPrefix = amount < 0 ? "-$" : "$";
        transactionCellAmountLabel.textProperty().set(amountPrefix + String.valueOf(amount));
    }

        public void initialize(){
        transactionCell.setOnMouseClicked(event -> {
            if(clickListener != null) {
                clickListener.onTransactionClicked(transaction);
            }
        });

            onDeleteButtonClicked();

//        transactionCellDeleteButton.setOnAction(event -> {
//            if(deleteListener != null) {
//                deleteListener.onTransactionDelete(transaction, transactionCell);
//            }
//        });

        transactionCellEditButton.setOnAction(event -> {
            if(editListener != null) {
                editListener.onEdit(transaction);
            }
        });
        }


    public void setTransactionCellItemLabel(String item) {
        transactionCellItemLabel.textProperty().set(transaction.getItem());
    }

//      handle all styling here
//    handle all click events
//    show detail view when a cell is clicked-----------
//      call the edit/create dialog when edit btn is pressed
//    tell the transactionsListController to remove the cell when delete is pressed



    public void setTransaction (Transaction t) {
        this.transaction = t;
        setTransactionCellItemLabel(t.getItem());
        setTransactionCellAmountLabel(t.getAmount());
//        transactionCellEditButton = new Button();
//        transactionCellDeleteButton = new Button();
    }

    @FXML
    private void handleCellClick() {
//        if(onTransactionSelected != null) {
//            onTransactionSelected.accept(transaction);
//        }

        System.out.println("cell clicked!");
        if(clickListener != null) {
            clickListener.onTransactionClicked(transaction);
        }
    }

    @FXML
    private void onDeleteButtonClicked(){
        System.out.println("deleteButtonClicked");
        transactionCellDeleteButton.setOnAction(event -> {
            if(deleteListener != null) {
                deleteListener.onTransactionDelete(transaction, transactionCell);
            }
        });
    }

    @FXML
    private void onEditButtonClicked(){
        System.out.println("editButtonClicked");
    }
}
