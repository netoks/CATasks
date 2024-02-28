package part4;

import part4.enums.Command;
import part4.exceptions.InvalidUserInputException;
import part4.records.ExpenseRecord;
import part4.records.IncomeRecord;
import part4.records.Record;

import java.io.IOException;
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
                    case SAVE_DATA_TO_FILE -> budget.saveDataToFile();
                    case LOAD_DATA_FROM_FILE -> budget.loadDataFromFile(scanner);
                    case SAVE_DATA_TO_JSON -> budget.saveDataToJson();
                    case LOAD_DATA_FROM_JSON -> budget.loadDataFromJson();
                    case STOP_PROGRAM -> run = false;
                    case null, default -> System.out.println("Invalid command");
                }
            } catch (InvalidUserInputException | IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while (run);
    }
}