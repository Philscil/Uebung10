package h2;

public class Feld {
    private boolean boese;
    private char direction;

    public Feld (boolean boese, char direction) {
        setBoese(boese);
        
        setDirection(direction);
    }

    public boolean getBoese() {
        return boese;
    }

    public char getDirection() {
        return direction;
    }

    public void setBoese(boolean boese) {
        this.boese = boese;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
}
