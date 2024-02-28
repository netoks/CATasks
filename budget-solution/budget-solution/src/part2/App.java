package part2;

import part2.enums.Command;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Budget budget = new Budget("Daily budget");


        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        do {
            Command.printCommands();
            switch (Command.getCommandByUserInput(scanner)) {
                case ADD_INCOME -> budget.addIncomeRecord(new IncomeRecord());
                case ADD_EXPENSE -> budget.addExpenseRecord(new ExpenseRecord());
                case VIEW_BALANCE -> budget.viewBalance();
                case VIEW_EXPENSES -> budget.viewExpenses();
                case VIEW_INCOMES -> budget.viewIncomes();
                case DELETE_RECORD_BY_ID -> budget.deleteRecordById(scanner);
                case STOP_PROGRAM -> run = false;
                case null, default -> System.out.println("Invalid command");
            }
        } while (run);
    }
}