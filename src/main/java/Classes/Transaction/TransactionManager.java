package Classes.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private static final List<Transaction> transactions = new ArrayList<>();


    public static Transaction addTransaction(double amount, LocalDate date,
                                             Transaction.Type type, int categoryId,
                                             String description) {
        Transaction transaction = new Transaction(amount, date, type, categoryId, description);
        transactions.add(transaction);
        return transaction;
    }


    public static boolean editTransaction(int transactionId, double newAmount, LocalDate newDate,
                                          Transaction.Type newType, int newCategoryId,
                                          String newDescription) {
        Transaction transaction = findById(transactionId);
        if (transaction == null) return false;

        return transaction.setDetails(newAmount, newDate, newType, newCategoryId, newDescription);
    }


    public static boolean deleteTransaction(int transactionId) {
        Transaction transaction = findById(transactionId);
        if (transaction == null) return false;

        transactions.remove(transaction);
        return true;
    }


    public static Transaction findById(int transactionId) {
        for (Transaction t : transactions) {
            if (t.getTransactionId() == transactionId) {
                return t;
            }
        }
        return null;
    }

    public static List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}