package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailListViewController {
    @FXML
    private Label itemDetailView, amountDetailView, categoryDetailView, noteDetailView;

    @FXML
    private Label itemInfoDetail, amountInfoDetail, categoryInfoDetail, noteInfoDetail;

    public void showTransaction(Transaction t) {
        itemInfoDetail.textProperty().set(t.getItem());
        amountInfoDetail.textProperty().set(String.valueOf(t.getAmount()));
        categoryInfoDetail.textProperty().set(t.getCategory());
        noteInfoDetail.textProperty().set(t.getNote());

    }
}
