package Classes.Report;

import java.time.LocalDate;

public abstract class Report {
    protected int reportID;
    protected int userID;
    protected LocalDate startDate;
    protected LocalDate endDate;
   // protected List<Transaction> transactions;

    public Report(int reportID, int userId, LocalDate startDate, LocalDate endDate/*, List<Transaction> transactions*/) {
        this.reportID = reportID;
        this.userID = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        //this.transactions = transactions;
    }

    public int getReportId(){
        return reportID;
    }

    public int getUserId(){
        return userID;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

//    public List<Transaction> getTransactions(){
//        return transactions;
//    }

    public abstract String generateReport();

    public double calculateIncome(){
        return 0; // to implement after transactions class
    }

    public double calculateExpenses(){
        return  0; // to implement after transactions class
    }

    public double calculateNetBalance(){
        return calculateIncome() - calculateExpenses();
    }
}
