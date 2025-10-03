package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import org.junit.jupiter.api.Test;

class TransactionListControllerTest {
    @Test
    void createTransactionsTest() {
        TransactionListController c = new TransactionListController();
        Transaction t1 = new Transaction("boba", "food", "fun with friends", 7.00);
        Transaction t2 = new Transaction("ipad", "electronics", "for school", 975.50 );

        c.addNewTransactionCell(t1);
        c.addNewTransactionCell(t2);


    }

}