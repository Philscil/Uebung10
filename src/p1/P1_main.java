package p1;

public class P1_main {
    public static void main(String[] args) {
        Betrag b1 = new Betrag(5, 80);
        Betrag b2 = new Betrag(3, 50);
        P1_main main = new P1_main();
        Betrag summe = main.Summe(b1, b2);
        System.out.println("Summe: " + summe.getEuro() + " Euro und " + summe.getCent() + " Cent");
    }

    public Betrag Summe(Betrag a, Betrag b) {
        int euroSum = a.getEuro() + b.getEuro();
        int centSum = a.getCent() + b.getCent();
        Betrag summe = new Betrag(euroSum, centSum);
        return summe;
    }
}
