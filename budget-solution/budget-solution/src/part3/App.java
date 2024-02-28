package part3;

import part3.enums.Command;
import part3.exceptions.InvalidUserInputException;
import part3.records.ExpenseRecord;
import part3.records.IncomeRecord;
import part3.records.Record;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Budget budget = new Budget("Daily budget");

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        do {
            try {
                Command.printCommands();
                switch (Command.getCommandByUserInput(scanner)) {
                    case ADD_RECORD -> budget.addRecord(new Record(scanner));
                    case ADD_INCOME -> budget.addIncomeRecord(new IncomeRecord(scanner));
                    case ADD_EXPENSE -> budget.addExpenseRecord(new ExpenseRecord(scanner));
                    case VIEW_BALANCE -> budget.viewBalance();
                    case VIEW_RECORDS -> budget.viewRecords();
                    case VIEW_EXPENSES -> budget.viewExpenses();
                    case VIEW_INCOMES -> budget.viewIncomes();
                    case DELETE_RECORD_BY_ID -> budget.deleteRecordById(scanner);
                    case EDIT_RECORD_BY_ID -> budget.editRecordById(scanner);
                    case REPLACE_RECORD_BY_ID -> budget.replaceRecordById(scanner);
                    case STOP_PROGRAM -> run = false;
                    case null, default -> System.out.println("Invalid command");
                }
            } catch (InvalidUserInputException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while (run);
    }
}