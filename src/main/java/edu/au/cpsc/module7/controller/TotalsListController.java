package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.model.Transaction;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
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

    private ExpenseTrackerAppController appController; //<-------------------------

    public void setAppController(ExpenseTrackerAppController appController) {//<-------------------------
        this.appController = appController;
    }

    public void setTransactions(ObservableList<Transaction> transactions) {
        this.transactions = transactions;
        setupBindings();

        this.transactions.addListener((ListChangeListener<Transaction>) change -> setupBindings());
    }

    private void setupBindings() {
        DoubleBinding totalIncome = Bindings.createDoubleBinding(() -> transactions.stream()
                        .filter(t -> t.getAmount() > 0).mapToDouble(Transaction::getAmount).sum(),
                transactions);

        DoubleBinding totalExpenses = Bindings.createDoubleBinding(() -> transactions.stream()
                        .filter(t -> t.getAmount() < 0).mapToDouble(Transaction::getAmount).sum(),
                transactions);


        DoubleBinding currentBalance = totalIncome.add(totalExpenses);

        totalIncomeLabel.textProperty().bind(totalIncome.asString("$%.2f"));
        totalExpensesLabel.textProperty().bind(totalExpenses.asString("$%.2f"));
        currentBalanceLabel.textProperty().bind(currentBalance.asString("$%.2f"));

    }


    @FXML
    protected void deleteMenuAction() {
        if (appController != null) {
            appController.deleteSelectedTransaction();
        }
    }

    @FXML
    protected void closeMenuAction() {
        Platform.exit();
    }

    @FXML
    protected void appearanceMenuAction() {
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Light", "Dark", "Light");
        choiceDialog.showAndWait().ifPresent(selection -> {
                if(appController != null) {
                    appController.setTheme(selection);
                }
        });
    }


    }

