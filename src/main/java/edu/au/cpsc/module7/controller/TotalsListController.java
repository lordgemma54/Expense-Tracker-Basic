package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class TotalsListController {
    @FXML
    private MenuItem menuItemClose, menuItemDelete, menuItemAppearance;

    @FXML
    private Label currentBalanceLabel, totalIncomeLabel, totalExpensesLabel;

    @FXML
    private Button exportButton;

    private Transaction transaction;

    private ObservableList<Transaction> transactions;

    public void setTransactions(ObservableList<Transaction> transactions) {
        this.transactions = transactions;
        setupBindings();

        this.transactions.addListener((ListChangeListener<Transaction>) change -> setupBindings());
    }

    private void setupBindings() {
        DoubleBinding totalIncome = Bindings.createDoubleBinding(() -> transactions.stream()
                        .filter(t-> t.getAmount() > 0).mapToDouble(Transaction::getAmount).sum(),
                transactions);

        DoubleBinding totalExpenses = Bindings.createDoubleBinding(() -> transactions.stream()
                .filter(t -> t.getAmount() < 0).mapToDouble(Transaction::getAmount).sum(),
                transactions);


        DoubleBinding currentBalance = totalIncome.add(totalExpenses);

        totalIncomeLabel.textProperty().bind(totalIncome.asString("$%.2f"));
        totalExpensesLabel.textProperty().bind(totalExpenses.asString("$%.2f"));
        currentBalanceLabel.textProperty().bind(currentBalance.asString("$%.2f"));

    }

}
