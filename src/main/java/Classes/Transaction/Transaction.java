package Classes.Transaction;

import java.sql.*;
import java.time.LocalDateTime;

public class Transaction {

    private int transactionId;
    private int userId;
    private String description;
    private double amount;
    private String type;
    private LocalDateTime date;

    /*URL. temporary name ang expense_tracker
    private final String url = "jdbc:mysql://localhost:3306/expense_tracker";
    private final String username = "root";
    private final String password = "";
    */

    public Transaction(int transactionId,
                       int userId,
                       String description,
                       double amount,
                       String type,
                       LocalDateTime date) {

        this.transactionId = transactionId;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }


    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }


    public boolean addTransaction() {
        System.out.println("Transaction added.");
        return true;

        /* with SQL. description is murag note like mcdo payment, shoppee order, foodpanda order
        String sql = "INSERT INTO transactions (user_id, description, amount, type, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, description);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, type);
            pstmt.setTimestamp(5, Timestamp.valueOf(date));

            int rows = pstmt.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

         */
    }


    public boolean editTransaction(String newDescription,
                                   double newAmount,
                                   String newType) {
        this.description = newDescription;
        this.amount = newAmount;
        this.type = newType;

        System.out.println("Transaction updated.");
        return true;
/*with SQL
        String sql = "UPDATE transactions SET description=?, amount=?, type=? WHERE transaction_id=?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newDescription);
            pstmt.setDouble(2, newAmount);
            pstmt.setString(3, newType);
            pstmt.setInt(4, transactionId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {

                this.description = newDescription;
                this.amount = newAmount;
                this.type = newType;

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

 */
    }


    public boolean deleteTransaction() {
        System.out.println("Transaction deleted.");
        return true;

        /*with SQL
        String sql = "DELETE FROM transactions WHERE transaction_id=?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, transactionId);

            int rows = pstmt.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
        */
    }
}
