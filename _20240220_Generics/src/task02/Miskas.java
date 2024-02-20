package task02;

import task02.medziai.Berzas;
import task02.medziai.Medis;
import task02.medziai.Spygliuotis;

import java.util.List;

public class Miskas <E extends Medis> {
    public void misrusMiskas (List<E> miskas) {
        for (E m : miskas) {
            System.out.println(m.turi());
        }
    }

    public void spygliuociuMiskas (List<? extends Spygliuotis> miskas) {
        for (Spygliuotis m : miskas) {
            System.out.println(m.turi());
        }
    }

    public void berzuMiskas (List<Berzas> miskas) {
        for (Berzas m : miskas) {
            System.out.println(m.turi());
        }
    }
}
