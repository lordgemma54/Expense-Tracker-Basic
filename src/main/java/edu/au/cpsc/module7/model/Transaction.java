package edu.au.cpsc.module7.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Transaction {

    private static double currentBalance;
    private static double totalIncome;
    private static double totalExpenses;

    private String item;
    private String category;
    private String note;
    private final DoubleProperty amount = new SimpleDoubleProperty();



    public Transaction() {}

    public Transaction(String item, String category, String note, double amount) {
            setItem(item);
            setCategory(category) ;
            setNote(note);
            setAmount(amount);
    }

    public DoubleProperty amountProperty() {return amount;}

    public static double getCurrentBalance() {
        return currentBalance;
    }

    public static double getTotalIncome() {
        return totalIncome;
    }

    public static double getTotalExpenses() {
        return totalExpenses;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "item='" + item + '\'' +
                ", category='" + category + '\'' +
                ", note='" + note + '\'' +
                ", amount=" + amount +
                '}';
    }
}
