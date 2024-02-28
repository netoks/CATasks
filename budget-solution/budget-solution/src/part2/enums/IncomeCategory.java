package part2.enums;

import java.util.Scanner;

public enum IncomeCategory {
    SALARY(0),
    INVESTMENT(1),
    GIFT(2),
    BONUS(3),
    PENSION(4);


    int id;

    IncomeCategory(int id) {
        this.id = id;
    }

    public static void printIncomeCategories() {
        for (IncomeCategory i : IncomeCategory.values()) {
            System.out.printf("[%d] - %s%n", i.id, i.name());
        }
    }

    public static IncomeCategory getIncomeCategoryByUserInput(Scanner scanner) {
        System.out.println("Select income category:");
        printIncomeCategories();
        try {
            Integer methodId = Integer.parseInt(scanner.nextLine());
            return getIncomeCategoryById(methodId);
        } catch (Exception e) {
            return null;
        }
    }

    private static IncomeCategory getIncomeCategoryById(Integer incomeCategoryId) {
        for (IncomeCategory i : IncomeCategory.values()) {
            if (i.id == incomeCategoryId) {
                return i;
            }
        }
        return null;
    }
}
