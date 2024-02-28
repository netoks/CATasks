package part1;

import part1.enums.Command;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Budget budget = new Budget("Daily budget");


        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        do {
            Command.printCommands();
            switch (Command.getCommandByUserInput(scanner)) {
                case ADD_INCOME -> budget.addIncomeRecord(new IncomeRecord(scanner));
                case ADD_EXPENSE -> budget.addExpenseRecord(new ExpenseRecord(scanner));
                case STOP_PROGRAM -> run = false;
                case null, default -> System.out.println("Invalid command");
            }
        } while (run);
    }
}