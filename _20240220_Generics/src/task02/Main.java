package task02;

import task02.medziai.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Medis> misrusMedziai = new ArrayList<>();
        misrusMedziai.add(new Azuolas());
        misrusMedziai.add(new Egle());
        misrusMedziai.add(new Kadagys());
        misrusMedziai.add(new Berzas());
        misrusMedziai.add(new Azuolas());

        Miskas.misrusMiskas(misrusMedziai);

        System.out.println();

        List<Spygliuotis> spygliuociaiMedziai = new ArrayList<>();
        spygliuociaiMedziai.add(new Egle());
        spygliuociaiMedziai.add(new Kadagys());
        spygliuociaiMedziai.add(new Egle());
        spygliuociaiMedziai.add(new Egle());

        Miskas.spygliuociuMiskas(spygliuociaiMedziai);
    }
}
