package task03;

import java.util.ArrayList;
import java.util.List;

public class Mapas<K, V> {
    private List<Pora<K, V>> sarasasPoru;

    public Mapas() {
        sarasasPoru = new ArrayList<>();
    }

    public void ideti (K raktas, V reiksme) {
        sarasasPoru.add(new Pora(raktas, reiksme));
    }

    public V gauti (K raktas) {
        for (Pora<K, V> pora : sarasasPoru) {
            if (pora.getRaktas().equals(raktas)) {
                return pora.getReiksme();
            }
        }
        return null;
    }
}
