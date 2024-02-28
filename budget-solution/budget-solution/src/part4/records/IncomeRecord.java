package part4.records;

import part4.enums.IncomeCategory;
import part4.exceptions.InvalidUserInputException;

import java.util.Scanner;

public class IncomeRecord extends Record {

    private IncomeCategory category;

    public IncomeRecord() {
    }
    public IncomeRecord(int id) {
        super(id);
    }

    public IncomeRecord(String[] csvFields){
        super(csvFields);
        //ID,TYPE,AMOUNT,CURRENCY,DESCRIPTION,PAYMENT_METHOD,INCOME_CATEGORY
        this.category = IncomeCategory.valueOf(csvFields[6]);
    }

    public IncomeRecord(Scanner scanner) throws InvalidUserInputException {
        super(scanner);
        this.category = IncomeCategory.getIncomeCategoryByUserInput(scanner);
    }

    @Override
    public void editRecord(Scanner scanner) throws InvalidUserInputException {
        super.editRecord(scanner);
        if (editParameter(scanner, "category", this.category.name())) {
            setCategory(IncomeCategory.getIncomeCategoryByUserInput(scanner));
        }
    }

    @Override
    public String toCSV() {
        return String.format("%s,I,%.2f,%s,%s,,%s%n", super.getId(), super.getAmount(), super.getCurrency(),
                super.getDescription(), this.category);
    }

    @Override
    public String toString() {
        return String.format("[%d] [INCOME] - {%s %.2f%s - %s}", super.getId(), this.category, super.getAmount(),
                super.getCurrency(),
                super.getDescription());
    }

    public IncomeCategory getCategory() {
        return category;
    }

    public void setCategory(IncomeCategory category) {
        this.category = category;
    }

}
