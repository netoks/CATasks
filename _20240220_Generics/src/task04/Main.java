package task04;

public class Main {
    public static void main(String[] args) {
        ListOfNumbers listObject1 = new ListOfNumbers();
        listObject1.addNumber(1.5d);
        listObject1.addNumber(10d);
        listObject1.addNumber(2.5d);

        ListOfNumbers listObject2 = new ListOfNumbers();
        listObject2.addNumber(0d);
        listObject2.addNumber(1d);

        ListOfNumbers listObject3 = new ListOfNumbers();
        listObject3.addNumber(100d);

        ListOfNumbers result1 = Util.findWithMaxAverage(listObject1, listObject2, listObject3);
        ListOfNumbers result2 = Util.findWithMaxAverage(listObject1, listObject2);

        System.out.println(result1);
        System.out.println(result2);
    }
}
