package part1;

public class Budget {

    String title;
    ExpenseRecord[] expenses = new ExpenseRecord[100];
    IncomeRecord[] incomes = new IncomeRecord[100];

    public Budget(String title) {
        this.title = title;
    }

    public void addIncomeRecord(IncomeRecord incomeRecord){
        incomes[IncomeRecord.counter++] = incomeRecord;
        System.out.println("Income added successfully!");
    }

    public void addExpenseRecord(ExpenseRecord expenseRecord){
        expenses[ExpenseRecord.counter++] = expenseRecord;
        System.out.println("Expense added successfully!");
    }
}
