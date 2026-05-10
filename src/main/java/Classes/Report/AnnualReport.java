package Classes.Report;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AnnualReport extends Report{
    private int year;

    public AnnualReport(int reportID, int userID, int year) {
        super(reportID, userID, LocalDate.of(year, 1, 1), LocalDate.of(year, 12, 31));
        this.year = year;
    }

    public String getAnnualSummary(){
        return "";
    }

    public double compareWithPreviousYear(){
        return 0.0;
    }

    public Map<String, Double> CategoryBreakdown(){
        return Map.of();
    }

    public List<Double> getMonthlyTrend(){
        return List.of();
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
