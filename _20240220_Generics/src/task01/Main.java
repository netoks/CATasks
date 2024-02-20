package task01;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayNumbers = {5, 1, 6};

        String[] arrayStrings = {"Congratulations", "Vilnius", "with 700th Birthday"};

        printArrayElements(arrayNumbers);
        printArrayElements(arrayStrings);
    }

    public static <E> void printArrayElements(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }
}