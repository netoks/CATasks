package part1.enums;

import java.util.Scanner;

public enum PaymentMethod {
    BANK(0, "bank transfer"),
    CARD(1, "card payment"),
    CASH(2, "cash");

    final int id;
    final String description;

    PaymentMethod(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static void printPaymentMethods() {
        for (PaymentMethod p : PaymentMethod.values()) {
            System.out.printf("[%d] - %s%n", p.id, p.name());
        }
        System.out.println();
    }

    public static PaymentMethod getPaymentMethodByUserInput(Scanner scanner) {
        System.out.println("Select payment method:");
        printPaymentMethods();
        try {
            Integer methodId = Integer.parseInt(scanner.nextLine());
            return getPaymentMethodById(methodId);
        } catch (Exception e) {
            return null;
        }
    }

    private static PaymentMethod getPaymentMethodById(Integer paymentMethodId) {
        for (PaymentMethod p : PaymentMethod.values()) {
            if (p.id == paymentMethodId) {
                return p;
            }
        }
        return null;
    }
}
