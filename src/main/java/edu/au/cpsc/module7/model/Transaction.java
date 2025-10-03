package edu.au.cpsc.module7.model;

public class Transaction {

    private static double currentBalance;
    private static double totalIncome;
    private static double totalExpenses;

    private String item;
    private String category;
    private String note;
    private double amount;

    public Transaction() {}

    public Transaction(String item, String category, String note, double amount) {
            this.item = item;
            this.category = category;
            this.note = note;
            this.amount = amount;
    }

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
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
