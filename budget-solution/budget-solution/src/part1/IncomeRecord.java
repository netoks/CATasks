package part1;

import part1.enums.IncomeCategory;

import java.util.Scanner;

public class IncomeRecord {

    public static Integer counter = 0;
    private Double amount;
    private String currency = "EUR";
    private String description;
    private IncomeCategory category;

    public IncomeRecord() {
    }

    public IncomeRecord(Scanner scanner) {
        System.out.println("Enter amount");
        this.amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter description");
        this.description = scanner.nextLine();
        this.category = IncomeCategory.getIncomeCategoryByUserInput(scanner);
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
}
