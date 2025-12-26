package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;

    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        setCurrentRow(indexRow);
        setCurrentCol(indexCol);

        setBrett(brett);
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        int x = 0;
        int y = 0;

        switch (brett.getBrett()[currentRow][currentCol].getDirection()) {
            case 'U':
                y--;
                break;
            case 'D':
                y++;
                break;
            case 'L':
                x--;
                break;
            case 'R':
                x++;
                break;
        }

        if ((x < 0 || x > brett.getDim()) || (y < 0 || y > brett.getDim())) {
            return true;
        } else {
            return false;
        }
    }

    public void go (int n) {
        if (n == 0) {
            return;
        }

        for (int i = 0; i <= n; i++) {
            if (movesOut()) {
                return;
            } else {
                if (!brett.getBrett()[currentRow][currentCol].getBoese()) {
                    switch (brett.getBrett()[currentRow][currentCol].getDirection()) {
                        case 'U':
                            setCurrentRow(getCurrentRow() - 1);
                            break;
                        case 'D':
                            setCurrentRow(getCurrentRow() + 1);
                            break;
                        case 'L':
                            setCurrentCol(getCurrentCol() - 1);
                            break;
                        case 'R':
                            setCurrentCol(getCurrentCol() + 1);
                            break;
                    }
                }
                else {
                    return;
                }
                
            }
        }
    }
}