package task04;

import java.util.ArrayList;

public class ListOfNumbers {
    private ArrayList<Double> numbers;

    public ListOfNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(Double number) {
        this.numbers.add(number);
    }

    public Double getAverage() {
        Double sum = 0.0;
        for (Double number : this.numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    @Override
    public String toString() {
        return String.format("%s{numbers=%s}", this.getClass().getSimpleName(), this.numbers.toString());
    }
}
