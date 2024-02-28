package part3.enums;

import java.util.Scanner;

public enum Command {
    STOP_PROGRAM(0, "stop program"),
    ADD_RECORD(1, "add record"),
    ADD_INCOME(2, "add income record"),
    ADD_EXPENSE(3, "add expense record"),
    VIEW_BALANCE(4, "view balance"),
    VIEW_RECORDS(5, "view records"),
    VIEW_EXPENSES(6, "view expenses"),
    VIEW_INCOMES(7, "view incomes"),
    DELETE_RECORD_BY_ID(8, "delete record by id"),
    EDIT_RECORD_BY_ID(9, "edit record by id"),
    REPLACE_RECORD_BY_ID(10, "replace record by id");

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

    public static boolean isAccepted(Scanner scanner){
        System.out.println("[1] - yes, [2] - no");
        String decision = scanner.nextLine();
        return decision.equals("1");
    }
}
