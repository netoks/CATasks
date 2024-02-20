package task02;

import task02.medziai.Medis;

import java.util.List;

public class Miskas <E extends Medis> {
    public void misrusMiskas (List<E> miskas) {
        for (E m : miskas) {
            System.out.println(m.turi());
        }
    }

    public void spygliuociuMiskas (List<E> miskas) {
        for (E m : miskas) {
            System.out.println(m.turi());
        }
    }

    public void berzuMiskas (List<E> miskas) {
        for (E m : miskas) {
            System.out.println(m.turi());
        }
    }
}
