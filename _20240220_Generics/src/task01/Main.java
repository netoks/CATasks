package task01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        arrayNumbers.add(5);
        arrayNumbers.add(1);
        arrayNumbers.add(6);

        ArrayList<String> arrayStrings = new ArrayList<>();
        arrayStrings.add("Congratulations");
        arrayStrings.add("Vilnius");
        arrayStrings.add("with 700th Birthday");

        printArrayElements(arrayNumbers);
        printArrayElements(arrayStrings);
    }

    public static <E> void printArrayElements(ArrayList<E> array) {
        for (E e : array) {
            System.out.println(e);
        }
    }
}