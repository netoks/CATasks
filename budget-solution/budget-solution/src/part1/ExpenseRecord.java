package part1;

import part1.enums.PaymentMethod;

import java.util.Scanner;

public class ExpenseRecord {

    public static Integer counter = 0;

    private Double amount;
    private String currency = "EUR";
    private String description;

    private PaymentMethod paymentMethod;

    public ExpenseRecord() {
    }

    public ExpenseRecord(Scanner scanner) {
        System.out.println("Enter amount");
        this.amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter description");
        this.description = scanner.nextLine();
        this.paymentMethod = PaymentMethod.getPaymentMethodByUserInput(scanner);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
