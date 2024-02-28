package part2;

import java.util.ArrayList;
import java.util.Scanner;

public class Budget {

    private String title;
    private final ArrayList<ExpenseRecord> expenses = new ArrayList<>();
    private final ArrayList<IncomeRecord> incomes = new ArrayList<>();

    public static int counter = 0;


    public Budget(String title) {
        this.title = title;
    }

    public void addIncomeRecord(IncomeRecord incomeRecord) {
        incomes.add(incomeRecord);
        System.out.println("Income added successfully!");
        System.out.println();
    }

    public void addExpenseRecord(ExpenseRecord expenseRecord) {
        expenses.add(expenseRecord);
        System.out.println("Expense added successfully!");
        System.out.println();
    }

    public void viewBalance() {
        System.out.println();
        System.out.printf("Your current balance is: %.2f€%n", getBalance());
        System.out.println();
    }

    public void viewExpenses() {
        System.out.println();
        for (ExpenseRecord expenseRecord : expenses) {
            System.out.println(expenseRecord);
        }
        System.out.println();
    }

    public void viewIncomes() {
        System.out.println();
        for (IncomeRecord incomeRecord : incomes) {
            System.out.println(incomeRecord);
        }
        System.out.println();
    }

    private void viewAllRecords() {
        ArrayList<Object> records = new ArrayList<>();
        records.addAll(expenses);
        records.addAll(incomes);
        for (Object r : records) {
            System.out.println(r);
        }
        System.out.println();
    }

    public void deleteRecordById(Scanner scanner) {
        viewAllRecords();
        System.out.println("Enter record ID you want to delete:");
        Integer recordId = Integer.parseInt(scanner.nextLine());

        if (incomes.remove(new IncomeRecord(recordId))){
            System.out.printf("Income record [%d] removed!%n", recordId);
            return;
        }

        if (expenses.remove(new ExpenseRecord(recordId))){
            System.out.printf("Expense record [%d] removed!%n", recordId);
            return;
        }

        System.out.printf("Record [%d] not found!%n", recordId);
    }


    private double getBalance() {
        double balance = 0.0;
        for (IncomeRecord i : incomes) {
            balance += i.getAmount();
        }
        for (ExpenseRecord e : expenses) {
            balance -= e.getAmount();
        }
        return balance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
