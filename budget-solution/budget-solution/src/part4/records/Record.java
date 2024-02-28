package part4.records;


import part4.enums.Command;
import part4.exceptions.InvalidUserInputException;

import java.util.Objects;
import java.util.Scanner;

public class Record {

    public static int counter = 0;
    private final Integer id;
    private Double amount;
    private String currency = "EUR";
    private String description;

    public Record() {
        this.id = Record.counter++;
    }

    public Record(int id) {
        this.id = id;
    }

    public Record(String[] csvFields){
        //ID,TYPE,AMOUNT,CURRENCY,DESCRIPTION,PAYMENT_METHOD,INCOME_CATEGORY
        this.id = Integer.parseInt(csvFields[0]);
        if (this.id >= Record.counter){
            Record.counter = this.id + 1;
        }
        this.amount = Double.parseDouble(csvFields[2]);
        this.currency = csvFields[3];
        this.description = csvFields[4];
    }

    public Record(Scanner scanner) throws InvalidUserInputException {
        this.id = Record.counter++;
        System.out.println();
        try {
            System.out.println("Enter amount");
            this.amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException("Amount should be of type Double", "amount", "String");
        }

        System.out.println("Enter description");
        this.description = scanner.nextLine();

    }

    protected boolean editParameter(Scanner scanner, String name, String value) {
        System.out.printf("%s: %s%n", name, value);
        System.out.printf("Edit %s?%n", name);
        return Command.isAccepted(scanner);
    }

    protected String getNewValue(Scanner scanner) {
        System.out.println("Enter new value:");
        return scanner.nextLine();
    }

    public void editRecord(Scanner scanner) throws InvalidUserInputException {
        if (editParameter(scanner, "amount", this.amount.toString())) {
            try {
                setAmount(Double.parseDouble(getNewValue(scanner)));
            } catch (Exception e) {
                throw new InvalidUserInputException("Invalid amount entered", "Amount", "Double");
            }
        }
        if (editParameter(scanner, "currency", this.currency)) {
            setCurrency(getNewValue(scanner));
        }
        if (editParameter(scanner, "description", this.description)) {
            setDescription(getNewValue(scanner));
        }
    }

    public String toCSV(){
        return String.format("%s,R,%.2f,%s,%s,,%n", this.id, this.amount, this.currency, this.description);
    }

    @Override
    public String toString() {
        return String.format("[%d] [RECORD] - {%.2f%s - %s}", this.getId(),
                this.getAmount(), this.getCurrency(),
                this.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
