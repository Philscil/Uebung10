package h2;

public class Spielbrett {
    private Feld[][] brett;
    private int dim;

    public Spielbrett(int dim) {
        setDim(dim);

        setBrett(new Feld[dim][dim]);
    }

    public Feld[][] getBrett() {
        return brett;
    }

    public int getDim() {
        return dim;
    }

    public void setBrett(Feld[][] brett) {
        this.brett = brett;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }
}
