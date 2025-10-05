package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class DetailListViewController {
    @FXML
    private Label itemDetailView, amountDetailView, categoryDetailView, noteDetailView;

    @FXML
    private Label itemInfoDetail, amountInfoDetail, categoryInfoDetail, noteInfoDetail;

    @FXML
    private GridPane detailListView;

    @FXML
    private AnchorPane detailListViewRoot;

    @FXML
    private Button hideButton;

    private boolean isShown = false;
//    private double hiddenPosition;
//    private double shownPosition;

    @FXML
    private void initialize() {
        detailListView.setOpacity(0);
        detailListView.setTranslateY(160);
//        detailListViewController.showTransaction(transaction);

        System.out.println("detail view loaded " + (detailListView != null));
    }

    //animate a sliding window here that shows the detail view

    public void showTransaction(Transaction t) {

        if(t == null) {
            hideDetailView();
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

        if(!isShown) {
            showDetailView();
        }
    }

    public void showDetailView() {
        TranslateTransition slideUp = new TranslateTransition(Duration.millis(400), detailListView);
        slideUp.setFromY(160);
        slideUp.setToY(0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(200), detailListView);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        ParallelTransition showAnim = new ParallelTransition(slideUp, fadeIn);
        showAnim.play();

        isShown = true;

    }

    public void hideDetailView() {
        if(!isShown) return;

        TranslateTransition slideDown = new TranslateTransition(Duration.millis(300), detailListView);
        slideDown.setFromY(0);
        slideDown.setToY(160);

        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), detailListView);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        ParallelTransition showAnim = new ParallelTransition(slideDown, fadeOut);
        showAnim.play();

        isShown = false;

    }

//    public void updateTransaction() {
//
//    }

    public void clearDetails() {
        itemInfoDetail.setText("");
        amountInfoDetail.setText("");
        categoryInfoDetail.setText("");
        noteInfoDetail.setText("");
    }

    @FXML
    protected void onHideButtonClicked(){
        hideDetailView();
    }

}
