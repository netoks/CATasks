package task02;

import task02.medziai.Berzas;
import task02.medziai.Medis;
import task02.medziai.Spygliuotis;

import java.util.List;

public abstract class Miskas {
    public static void misrusMiskas (List<? extends Medis> miskas) {
        for (Medis m : miskas) {
            m.turi();
        }
    }

    public static void spygliuociuMiskas (List<? extends Spygliuotis> miskas) {
        for (Spygliuotis m : miskas) {
            m.turi();
        }
    }

    public static void berzuMiskas (List<Berzas> miskas) {
        for (Berzas m : miskas) {
            m.turi();
        }
    }
}
