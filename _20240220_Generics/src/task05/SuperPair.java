package task05;

public class SuperPair <T1, T2, T3 extends Number> {

    private T1 variable1;
    private T2 variable2;
    private T3 variable3;

    public SuperPair(T1 variable1, T2 variable2, T3 variable3) {
        this.variable1 = variable1;
        this.variable2 = variable2;
        this.variable3 = variable3;
    }
}
