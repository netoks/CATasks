package taskBonus;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int solution(int[] A) {
        int toReturn = 1;
        ArrayList<Integer> result = new ArrayList<>();
        getPositiveElementsInAnArray(A, result);

        if (result.isEmpty()) return toReturn;
        if (result.size() == 1) return result.getFirst() + 1;

        Collections.sort(result);

        toReturn = getFirstPositiveNumberOntInArrayList(result, toReturn);

        return toReturn;
    }

    private static int getFirstPositiveNumberOntInArrayList(ArrayList<Integer> result, int toReturn) {
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) - result.get(i-1) > 1) {
                toReturn = result.get(i-1) + 1;
            } else if (i == (result.size() - 1)) {
                toReturn = result.get(i) + 1;
            }
        }
        return toReturn;
    }

    private static void getPositiveElementsInAnArray(int[] A, ArrayList<Integer> result) {
        for (int i : A) {
            if (i > 0) {
                result.add(i);
            }
        }
    }
}
