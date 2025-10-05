package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;

public interface EditCreateListener {
    void onSave(Transaction transaction, boolean isNew);

    default void onCancel(){}

    default void onEdit(Transaction transacton){}
}
