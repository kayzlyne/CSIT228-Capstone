package Classes.Transaction;

import java.time.LocalDate;

public class Transaction {

    public enum Type {
        INCOME, EXPENSE
    }

    private static int nextId = 1;

    private int transactionId;
    private double amount;
    private LocalDate date;
    private Type type;
    private int categoryId;
    private String description;

    public Transaction(double amount, LocalDate date, Type type, int categoryId, String description) {
        this.transactionId = nextId++;
        if (!setDetails(amount, date, type, categoryId, description)) {
            throw new IllegalArgumentException("Invalid transaction details.");
        }
    }


    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }


    public boolean setDetails(double amount, LocalDate date, Type type, int categoryId, String description) {
        if (amount < 0) return false;
        if (date == null) return false;
        if (type == null) return false;
        if (description == null || description.trim().isEmpty()) return false;

        this.amount = amount;
        this.date = date;
        this.type = type;
        this.categoryId = categoryId;
        this.description = description.trim();
        return true;
    }

    @Override
    public String toString() {
        return "[" + transactionId + "] " + type + " | ₱" + amount + " | " + date + " | " + description;
    }
}