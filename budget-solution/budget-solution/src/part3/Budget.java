package part3;

import part3.exceptions.InvalidUserInputException;
import part3.records.ExpenseRecord;
import part3.records.IncomeRecord;
import part3.records.Record;

import java.util.ArrayList;
import java.util.Scanner;

public class Budget {

    private String title;
    private final ArrayList<Record> records = new ArrayList<>();


    public Budget(String title) {
        this.title = title;
    }

    public void addRecord(Record record) {
        records.add(record);
        System.out.println("Record added successfully!");
        System.out.println();
    }

    public void addIncomeRecord(IncomeRecord incomeRecord) {
        records.add(incomeRecord);
        System.out.println("Income added successfully!");
        System.out.println();
    }

    public void addExpenseRecord(ExpenseRecord expenseRecord) {
        records.add(expenseRecord);
        System.out.println("Expense added successfully!");
        System.out.println();
    }

    public void viewBalance() {
        System.out.println();
        System.out.printf("Your current balance is: %.2f€%n", getBalance());
        System.out.println();
    }

    private ArrayList<ExpenseRecord> getExpenseRecords() {
        ArrayList<ExpenseRecord> expenseRecords = new ArrayList<>();
        for (Record record : records) {
            if (record instanceof ExpenseRecord expenseRecord) {
                expenseRecords.add(expenseRecord);
            }
        }
        return expenseRecords;
    }

    private ArrayList<IncomeRecord> getIncomeRecords() {
        ArrayList<IncomeRecord> incomeRecords = new ArrayList<>();
        for (Record record : records) {
            if (record instanceof IncomeRecord expenseRecord) {
                incomeRecords.add(expenseRecord);
            }
        }
        return incomeRecords;
    }

    public void viewRecords() {
        System.out.println();
        for (Record r : records) {
            System.out.println(r);
        }
        System.out.println();
    }

    public void viewExpenses() {
        System.out.println();
        for (Record r : getExpenseRecords()) {
            System.out.println(r);
        }
        System.out.println();
    }

    public void viewIncomes() {
        System.out.println();
        for (Record r : getIncomeRecords()) {
            System.out.println(r);
        }
        System.out.println();
    }

    private void viewAllRecords() {
        System.out.println();
        for (Record r : records) {
            System.out.println(r.toString());
        }
        System.out.println();
    }

    private Record getRecordById(Scanner scanner) {
        int recordIndex = records.indexOf(new Record(Integer.parseInt(scanner.nextLine())));
        if (recordIndex == -1) {
            return null;
        }
        return records.get(recordIndex);
    }

    public void editRecordById(Scanner scanner) throws InvalidUserInputException {
        viewAllRecords();
        System.out.println("Enter record ID you want to edit:");
        Record recordToEdit = getRecordById(scanner);
        recordToEdit.editRecord(scanner);
    }

    public void replaceRecordById(Scanner scanner) throws InvalidUserInputException {
        viewAllRecords();
        System.out.println("Enter record ID you want to replace:");
        int indexToReplace = records.indexOf(new Record(Integer.parseInt(scanner.nextLine())));
        if (indexToReplace == -1){
            System.out.println("No record found");
            return;
        }
        records.set(indexToReplace, new Record(scanner));
    }

    public void deleteRecordById(Scanner scanner) {
        viewAllRecords();
        System.out.println("Enter record ID you want to delete:");
        if (records.remove(new Record(Integer.parseInt(scanner.nextLine())))) {
            System.out.println("Record deleted successfully!");
        } else {
            System.out.println("Failed to delete record");
        }
    }


    private double getBalance() {
        double balance = 0.0;
        for (Record r : records) {
            if (r instanceof ExpenseRecord) {
                balance -= r.getAmount();
            }
            if (r instanceof IncomeRecord) {
                balance += r.getAmount();
            }
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
