package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TransactionListController {

    @FXML
    private VBox transactionList;

    private TransactionClickListener clickListener;

    @FXML
    private HBox cellButtonHBox;


    public void initialize() throws IOException {

        System.out.println("transactionList: " + transactionList);
        //demo transactions
        Transaction t1 = new Transaction("boba", "food", "fun with friends", 7.00);
        Transaction t2 = new Transaction("ipad", "electronics", "for school", 975.50 );
        Transaction t3 = new Transaction("TP", "staples", "for butts", 17.85);
        Transaction t4 = new Transaction("paycheck", "income", "for my sweat", 2000 );
        //controllers are instantiated by the fxml loader, so this line wont work
//        TransactionListController c = new TransactionListController();
        addNewTransactionCell(t1);
        addNewTransactionCell(t2);
        addNewTransactionCell(t3);
        addNewTransactionCell(t4);
    }



    public void setClickListener(TransactionClickListener listener) {
        this.clickListener = listener;
    }

//    probably just need to implement something here that creates new list cells with each new transaction

public void addNewTransactionCell(Transaction t){
    try {
//        URL fxmlLocation = getClass().getResource("/edu/au/cpsc/module7/transaction-cell.fxml");
//        System.out.println("FXML path; " + fxmlLocation);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/module7/transaction-cell.fxml"));
        Node transactionCell = loader.load();
        TransactionCellController cellController = loader.getController();

        cellController.setTransaction(t);

        cellController.setClickListener(clickListener);
//        button event handling here

        System.out.println("cell added");

        transactionList.getChildren().addAll(transactionCell);
    }catch (IOException e) {
        e.printStackTrace();
    }
}

//private void transactionSelected() {
//        Transaction selectedTransaction = transactionList.getSelectionModel().getSelected();
//
//}

public void deleteTransaction(Transaction t) {
        transactionList.getChildren().remove(t);

}

//    public void showTransaction(Transaction t) {
//        detailListViewController.showTransaction(t);
//    }

//    because you must call this method to connect the two views
    public void setDetailListViewController(DetailListViewController detailViewController) {
    }
}
