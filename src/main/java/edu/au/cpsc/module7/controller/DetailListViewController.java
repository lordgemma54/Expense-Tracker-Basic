package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailListViewController {
    @FXML
    private Label itemDetailView, amountDetailView, categoryDetailView, noteDetailView;

    @FXML
    private Label itemInfoDetail, amountInfoDetail, categoryInfoDetail, noteInfoDetail;

    //animate a sliding window here that shows the detail view

    public void showTransaction(Transaction t) {

        if(t == null) {
            itemInfoDetail.setText("");
            amountInfoDetail.setText("");
            categoryInfoDetail.setText("");
            noteInfoDetail.setText("");
            return;
        }
        itemInfoDetail.textProperty().set(t.getItem());
        amountInfoDetail.textProperty().set(String.valueOf(t.getAmount()));
        categoryInfoDetail.textProperty().set(t.getCategory());
        noteInfoDetail.textProperty().set(t.getNote());

    }
}
