package part3.records;

import part3.enums.PaymentMethod;
import part3.exceptions.InvalidUserInputException;

import java.util.Scanner;

public class ExpenseRecord extends Record {

    private PaymentMethod paymentMethod;

    public ExpenseRecord() {
    }

    public ExpenseRecord(int id) {
        super(id);
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
