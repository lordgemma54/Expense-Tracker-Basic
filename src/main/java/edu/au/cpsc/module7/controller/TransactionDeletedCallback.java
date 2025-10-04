package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;

public interface TransactionDeletedCallback {
    void onTransactionDeleted(Transaction t);
}
