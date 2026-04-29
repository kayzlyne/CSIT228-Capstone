package Classes.Report;

import java.util.List;
import java.util.Map;

public class AnnualReport extends Report{
    private int year;

    public String getAnnualSummary(){
        return "";
    }

    public double compareWithPreviousYear(){
        return 0.0;
    }

    public Map<String, Double> CategoryBreakdown(){
        return "";
    }

    public List<Double> getMonthlyTrend(){

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
