package part2.enums;

import java.util.Scanner;

public enum Command {
    STOP_PROGRAM(0, "stops program"),
    ADD_INCOME(1, "add income record"),
    ADD_EXPENSE(2, "add expense record"),
    VIEW_BALANCE(3, "view balance"),
    VIEW_EXPENSES(4, "view expenses"),
    VIEW_INCOMES(5, "view incomes"),
    DELETE_RECORD_BY_ID(6, "delete record by id");

    final int id;

    final String description;

    Command(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static void printCommands() {
        System.out.println("AVAILABLE COMMANDS");
        for (Command c : Command.values()) {
            System.out.printf("[%d] - %s%n", c.id, c.description);
        }
        System.out.println();
    }

    public static Command getCommandByUserInput(Scanner scanner) {
        System.out.println("Enter command:");
        try {
            Integer commandId = Integer.parseInt(scanner.nextLine());
            return getCommandById(commandId);
        } catch (Exception e) {
            return null;
        }
    }

    private static Command getCommandById(Integer commandId) {
        for (Command c : Command.values()) {
            if (c.id == commandId) {
                return c;
            }
        }
        return null;
    }
}
