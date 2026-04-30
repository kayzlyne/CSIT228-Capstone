package Classes.Budget;

import java.time.LocalDate;

public class Budget {
    private int budgetId;
    private double amountLimit;
    private int categoryId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Budget(int budgetId, int categoryId, double amountLimit, LocalDate startDate, LocalDate endDate) {
        this.budgetId = budgetId;
        if (!setBudgetLimit(categoryId, amountLimit, startDate, endDate)) {
            throw new IllegalArgumentException();
        }
    }

    public int getBudgetId() {
        return budgetId;
    }

    public double getAmountLimit() {
        return amountLimit;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean setBudgetLimit(int categoryId, double amountLimit, LocalDate startDate, LocalDate endDate) {
        if (amountLimit < 0) {
            return false;
        }

        if (endDate.isBefore(startDate)) {
            return false;
        }

        this.categoryId = categoryId;
        this.amountLimit = amountLimit;
        this.startDate = startDate;
        this.endDate = endDate;
        return true;
    }

    public boolean checkLimit(int categoryId, double totalExpense) {
        if (this.categoryId != categoryId) {
            return false;
        }
        return totalExpense <= amountLimit;
    }

}