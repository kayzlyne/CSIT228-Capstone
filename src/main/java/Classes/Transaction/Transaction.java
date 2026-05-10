package Transaction;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int userId;
    private String description;
    private double amount;
    private String type;
    private LocalDateTime date;

    public Transaction(int userId, String description, double amount, String type) {
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = LocalDateTime.now();
    }


}
