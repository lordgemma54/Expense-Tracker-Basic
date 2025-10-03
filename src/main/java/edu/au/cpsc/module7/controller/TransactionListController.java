package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TransactionListController {
//    private
    private VBox transactionList;
//    probably just need to implement something here that creates new list cells with each new transaction

public void addNewTransactionCell(Transaction t){
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edu.au.cpsc.module7.transaction-cell.fxml"));
        Node transactionCell = loader.load();
        TransactionCellController cellController = loader.getController();
        cellController.setTransaction(t);

//        button event handling here

        transactionList.getChildren().addAll(transactionCell);
    }catch (IOException e) {
        e.printStackTrace();
    }
}

public void intialize() throws IOException {

    }
}
