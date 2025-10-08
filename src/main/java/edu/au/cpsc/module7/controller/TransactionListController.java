package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

import java.io.IOException;

public class TransactionListController {

    @FXML
    private VBox transactionList;

    private TransactionClickListener clickListener;

    private TransactionDeletedCallback deletedCallback;

    private TransactionCellController transactionCellController;

    @FXML
    private HBox cellButtonHBox;

    @FXML
    private Button addNewTransactionButton;

    private ExpenseTrackerAppController appController;

    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    public void setAppController(ExpenseTrackerAppController appController) {//<-------------------------
        this.appController = appController;
    }

    public void initialize() throws IOException {
    addNewTransactionButton.setOnAction(event -> openCreateWindow());

//    for(Node cell : transactionList) {
//        totalCellAmount += transactionCellController.getCellAmount();
//    }


//        System.out.println("transactionList: " + transactionList);
//        //demo transactions
//        Transaction t1 = new Transaction("boba", "food", "fun with friends", 7.00);
//        Transaction t2 = new Transaction("ipad", "electronics", "for school", 975.50 );
//        Transaction t3 = new Transaction("TP", "staples", "for butts", 17.85);
//        Transaction t4 = new Transaction("paycheck", "income", "for my sweat", 2000 );
//        //controllers are instantiated by the fxml loader, so this line wont work
////        TransactionListController c = new TransactionListController();
//        addNewTransactionCell(t1);
//        addNewTransactionCell(t2);
//        addNewTransactionCell(t3);
//        addNewTransactionCell(t4);
    }


public void setTransactions(ObservableList<Transaction> transactions) {
    this.transactions = transactions;
//        new test:
    transactionList.getChildren().clear();
    for (Transaction t : transactions) {
        addNewTransactionCell(t);
    }

    transactions.addListener((ListChangeListener<Transaction>) change -> {
        while(change.next()) {
            if(change.wasAdded()) {
                for (Transaction t : change.getAddedSubList()) {
                    addNewTransactionCell(t);
                }
            }
            if(change.wasRemoved()) {
                for (Transaction t : change.getRemoved()) {
                    transactionList.getChildren().removeIf(node -> {
                        Object data = node.getUserData();
                        return data instanceof Transaction && data.equals(t);
                    });
                }
            }
        }
    });
//    refreshTransactionCells();

}
//    private void refreshTransactionCells() {
//        transactionList.getChildren().clear();
//        for(Transaction t : transactions) {
////        TransactionCellController cell = createTransactionCell(t);
////        transactionList.getChildren().add(cell.getRoot());
//        }
//    }

    public void setClickListener(TransactionClickListener listener) {
        this.clickListener = listener;
    }

    public void setDeletedCallback(TransactionDeletedCallback callback) {
        this.deletedCallback = callback;
    }

    public void addNewTransactionCell(Transaction t){
//        Window ownerWindow = addNewTransactionButton.getScene().getWindow();
        Window ownerWindow = (addNewTransactionButton.getScene() != null) ?
            addNewTransactionButton.getScene().getWindow() : null;

        boolean dark = appController.isDarkThemeEnabled();

        try {

//        URL fxmlLocation = getClass().getResource("/edu/au/cpsc/module7/transaction-cell.fxml");
//        System.out.println("FXML path; " + fxmlLocation);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/module7/transaction-cell.fxml"));
            Node transactionCell = loader.load();
            TransactionCellController cellController = loader.getController();

            cellController.setTransaction(t);

            cellController.setClickListener(clickListener);

            transactionCell.setUserData(t);

//            ----------------------Delete-------------------------------------

            cellController.setDeleteListener((transaction, cellNode) -> {
                transactionList.getChildren().remove(cellNode);
                transactions.remove(transaction);
                if(deletedCallback != null) {
                    deletedCallback.onTransactionDeleted(transaction);
                }
//            updateTotalsAfterDelete(transaction);
            });

//            ----------------------Edit-------------------------------------
            cellController.setEditCreateListener(new EditCreateListener() {
                @Override
                public void onEdit(Transaction transaction) {
                    try{
                        Window owner = addNewTransactionButton.getScene() != null ? addNewTransactionButton.getScene().getWindow() : null;

//                        Window owner = addNewTransactionButton.getScene().getWindow();
                        Transaction updatedTransaction = EditCreateWindowController.showModal(transaction, owner, dark);

                        if(updatedTransaction != null) {
                            cellController.setTransaction(updatedTransaction);

                            if(clickListener != null) {
                                clickListener.onTransactionClicked(updatedTransaction);
                            }
                            System.out.println("transaction updated");
                        }
                    }catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                }
                public void onSave(Transaction transaction, boolean isNew) {}
            });



            transactionList.getChildren().addAll(transactionCell);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void openCreateWindow() {
    try{
        Window ownerWindow = (addNewTransactionButton.getScene() != null) ? addNewTransactionButton.getScene().getWindow():
                null;

        boolean dark = appController != null && appController.isDarkThemeEnabled();

        Transaction newTransaction = EditCreateWindowController.showModal(null, ownerWindow, dark);

        if(newTransaction != null) {
            transactions.add(newTransaction);
//            addNewTransactionCell(newTransaction);
            System.out.println("New Transaction added: " + newTransaction.getItem());

            if(clickListener != null) {
                clickListener.onTransactionClicked(newTransaction);
            }
        }
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    }


//private void openEditWindow(Transaction transaction, Node cellNode) {
//        try{
//           Window ownerWindow = addNewTransactionButton.getScene().getWindow();
//
//            Transaction updatedTransaction = EditCreateWindowController.showModal(transaction, ownerWindow);
//
//            if(updatedTransaction != null) {
//                if(clickListener != null) {
//                    clickListener.onTransactionClicked(updatedTransaction);
//                }
//                System.out.println("Transaction updated: " + updatedTransaction.getItem());
//            }
//
//
//        }catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//}

//public void deleteTransaction(Transaction t) {
//        transactionList.getChildren().remove(t);
//
//}

//    public void showTransaction(Transaction t) {
//        detailListViewController.showTransaction(t);
//    }

//    because you must call this method to connect the two views
//    public void setDetailListViewController(DetailListViewController detailViewController) {
//    }
}
