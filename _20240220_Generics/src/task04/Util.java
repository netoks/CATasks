package task04;

public abstract class Util {
    public static ListOfNumbers findWithMaxAverage(ListOfNumbers... list) {
        ListOfNumbers maxAverageList = list[0];
        Double maxAverageValue = list[0].getAverage();
        for (int i = 1; i < list.length; i++) {
            if (list[i].getAverage() > maxAverageValue) {
                maxAverageValue = list[i].getAverage();
                maxAverageList = list[i];
            }
        }
        return maxAverageList;
    }
}
