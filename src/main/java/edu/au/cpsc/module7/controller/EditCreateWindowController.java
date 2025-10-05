package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class EditCreateWindowController {
    @FXML
    private Label itemCreateLabel, amountCreateLabel, categoryCreateLabel, noteCreateLabel;

    @FXML
    private TextField itemCreateTextField, amountCreateTextField, categoryCreateTextField, noteCreateTextField;

    @FXML
    private RadioButton incomeRadioButton, expenseRadioButton;

    private DetailListViewController detailListViewController;

    @FXML
    private Button saveButton, cancelButton;

    //    -------------------------------new stuff from last night---------------------------------
    private EditCreateListener listener;
    private boolean isNew = true;
    private boolean saved = false;
    private Transaction editingTransaction;


    public void setTransactionToEdit(Transaction t) {
        if(t != null) {
            this.editingTransaction = t;
            this.isNew = false;
            populateFields(t);
        }else {
            this.isNew = true;
            this.editingTransaction = null;
            clearFields();

//            editingTransaction = new Transaction("", "", "", 0);
        }
    }

    public void setEditCreateListener(EditCreateListener listener){
        this.listener = listener;
    }

@FXML
private void initialize(){
        saveButton.setOnAction(event -> onSave());
        cancelButton.setOnAction(event -> onCancel());
}

private void populateFields(Transaction t) {
    itemCreateTextField.setText(t.getItem());
    amountCreateTextField.setText(String.valueOf(t.getAmount()));
    categoryCreateTextField.setText(t.getCategory());
    noteCreateTextField.setText(t.getNote());

//    radio button stuff here?
//    if(t.getAmount() >= 0) incomeRadioButton.setSelected(true);
//    else expenseRadioButton.setSelected(true);
}

private void clearFields() {
    itemCreateTextField.clear();
    amountCreateTextField.clear();
    categoryCreateTextField.clear();
    noteCreateTextField.clear();

//    incomeRadioButton.setSelected(false);
//    expenseRadioButton.setSelected(false);
}

private void onSave() {
        String item = itemCreateTextField.getText().trim();
        String category = categoryCreateTextField.getText().trim();
        String note = noteCreateTextField.getText().trim();
        double amount;
        try{
            amount = Double.parseDouble(amountCreateTextField.getText().trim());
        }catch (NumberFormatException nfe) {
            System.err.println("Invalid amount");
            return;
        }

        if(isNew) {
            editingTransaction = new Transaction(item, category, note, amount);
            if(listener != null) listener.onSave(editingTransaction, true);
        } else {
            editingTransaction.setItem(item);
            editingTransaction.setCategory(category);
            editingTransaction.setNote(note);
            editingTransaction.setAmount(amount);
            if (listener != null) listener.onSave(editingTransaction, false);
        }

        saved = true;
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
}

private void onCancel() {
        if(listener != null) listener.onCancel();
    Stage stage = (Stage) saveButton.getScene().getWindow();
    stage.close();


}

//    -------------------------------new stuff from last night---------------------------------

    public static Transaction showModal(Transaction transaction, Window owner) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EditCreateWindowController.class.getResource("/edu/au/cpsc/module7/edit-create-window-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        EditCreateWindowController controller = fxmlLoader.getController();
        controller.setTransactionToEdit(transaction);

        Stage stage = new Stage();
        stage.setTitle("Transaction editor");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.showAndWait();

        if(controller.saved) {
               return controller.editingTransaction;
           } else {
               return null;
           }
        }
//        stage.show();
//        returning null till i understand this better


//    private void editTransaction(Transaction transaction) {
//    detailListViewController.showTransaction(transaction);
//    }

}


