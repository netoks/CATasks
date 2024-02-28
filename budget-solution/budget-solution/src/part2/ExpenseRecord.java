package part2;

import part2.enums.PaymentMethod;

import java.util.Objects;
import java.util.Scanner;

public class ExpenseRecord {

    private final Integer id;

    private Double amount;
    private String currency = "EUR";
    private String description;

    private PaymentMethod paymentMethod;

    public ExpenseRecord() {
        this.id = Budget.counter++;
    }

    public ExpenseRecord(int id) {
        this.id = id;
    }

    public ExpenseRecord(Scanner scanner) {
        this.id = Budget.counter++;
        System.out.println();
        System.out.println("Enter amount");
        this.amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter description");
        this.description = scanner.nextLine();
        this.paymentMethod = PaymentMethod.getPaymentMethodByUserInput(scanner);
    }

    @Override
    public String toString() {
        return String.format("[%d] [EXPENSE] - {%s %.2f%s - %s}", this.id, this.paymentMethod, this.amount, this.currency,
                this.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseRecord that = (ExpenseRecord) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public Integer getId() {
        return id;
    }
}
