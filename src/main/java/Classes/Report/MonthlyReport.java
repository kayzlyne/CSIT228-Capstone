package Classes.Report;

import java.time.LocalDate;
import java.time.YearMonth;

public class MonthlyReport extends Report{
    private int month;
    private int year;

    public MonthlyReport(int reportID, int userID, int month, int year/*, List<Transaction> transactions*/) {
        super(reportID, userID, LocalDate.of(year, month, 1), YearMonth.of(year, month).atEndOfMonth());
        this.month = month;
        this.year = year;
      //  this.transactions = transactions;
    }

    public String getMonthlySummary(){
        return "";
    }

    public double compareWithPreviousMonth(){
        return 0.0;
    }

    @Override
    public String generateReport() {
        return "";
    }

    @Override
    public double calculateIncome() {
        return 0;
    }

    @Override
    public double calculateExpenses() {
        return 0;
    }

    @Override
    public double calculateNetBalance() {
        return 0;
    }
}
