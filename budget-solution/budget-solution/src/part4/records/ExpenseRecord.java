package part4.records;

import part4.enums.IncomeCategory;
import part4.enums.PaymentMethod;
import part4.exceptions.InvalidUserInputException;

import java.util.Scanner;

public class ExpenseRecord extends Record {

    private PaymentMethod paymentMethod;

    public ExpenseRecord() {
    }

    public ExpenseRecord(int id) {
        super(id);
    }

    public ExpenseRecord(String[] csvFields){
        super(csvFields);
        //ID,TYPE,AMOUNT,CURRENCY,DESCRIPTION,PAYMENT_METHOD,INCOME_CATEGORY
        this.paymentMethod = PaymentMethod.valueOf(csvFields[5]);
    }

    public ExpenseRecord(Scanner scanner) throws InvalidUserInputException {
        super(scanner);
        this.paymentMethod = PaymentMethod.getPaymentMethodByUserInput(scanner);
    }

    @Override
    public void editRecord(Scanner scanner) throws InvalidUserInputException {
        super.editRecord(scanner);
        if (editParameter(scanner, "category", this.paymentMethod.name())){
            setPaymentMethod(PaymentMethod.getPaymentMethodByUserInput(scanner));
        }
    }

    @Override
    public String toCSV() {
        return String.format("%s,E,%.2f,%s,%s,%s,%n", super.getId(), super.getAmount(), super.getCurrency(),
                super.getDescription(), this.paymentMethod);
    }

    @Override
    public String toString() {
        return String.format("[%d] [EXPENSE] - {%s %.2f%s - %s}", super.getId(), this.paymentMethod,
                super.getAmount(), super.getCurrency(),
                super.getDescription());
    }


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
