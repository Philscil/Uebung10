package p1;

public class Betrag {
    private int euro;
    private int cent;

    public Betrag(int euro, int cent) {
        this.setEuro(euro);
        this.setCent(cent);
    }

    public int getEuro() {
        return euro;
    }

    public int getCent() {
        return cent;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public void setCent(int cent) {
        if (cent > 100 ) {
            this.euro += cent / 100;
            this.cent = cent % 100;
        } else {
            this.cent = cent;
        }

        System.out.println("Euro: " + this.euro + " Cent: " + this.cent);
    }
}
