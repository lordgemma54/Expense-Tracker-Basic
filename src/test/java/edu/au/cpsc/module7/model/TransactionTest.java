package edu.au.cpsc.module7.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void transactionInstanceTest() {
        Transaction t1 = new Transaction("boba", "food", "fun with friends", 7.00);
        assertEquals("boba", t1.getItem());
        assertEquals("food", t1.getCategory());
        assertEquals("fun with friends", t1.getNote());
        assertEquals(7.00, t1.getAmount(), 0.0001);
    }
}

