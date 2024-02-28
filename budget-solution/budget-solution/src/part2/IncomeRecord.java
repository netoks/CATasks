package part2;

import part2.enums.IncomeCategory;

import java.util.Objects;
import java.util.Scanner;

public class IncomeRecord {

    private final Integer id;
    private Double amount;
    private String currency = "EUR";
    private String description;
    private IncomeCategory category;

    public IncomeRecord() {
        this.id = Budget.counter++;
    }

    public IncomeRecord(int id) {
        this.id = id;
    }

    public IncomeRecord(Scanner scanner) {
        this.id = Budget.counter++;
        System.out.println();
        System.out.println("Enter amount");
        this.amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter description");
        this.description = scanner.nextLine();
        this.category = IncomeCategory.getIncomeCategoryByUserInput(scanner);
    }

    @Override
    public String toString() {
        return String.format("[%d] [INCOME] - {%s %.2f%s - %s}", this.id, this.category, this.amount, this.currency,
                this.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeRecord that = (IncomeRecord) o;
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

    public IncomeCategory getCategory() {
        return category;
    }

    public void setCategory(IncomeCategory category) {
        this.category = category;
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
