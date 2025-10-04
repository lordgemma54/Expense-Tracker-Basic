package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.scene.Node;

public interface TransactionDeleteListener {
//    transaction is the Transaction model represented by this cell
//    cellNode is the Node that is the rood of the cell's UI so the caller can remove quickly'
    void onTransactionDelete(Transaction t, Node cellNode);
}
