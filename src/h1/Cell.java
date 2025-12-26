package h1;

public class Cell {
    private int indexRow;
    private int indexCol;

    private boolean alive;

    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = false;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean getIsAliveNextGen() {
        return isAliveNextGen;
    }

    public void setIsAliveNextGen(boolean isAliveNextGen) {
        this.isAliveNextGen = isAliveNextGen;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int livingNeighbors = 0;
        int rows = gridArray.length;
        int cols = gridArray[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int neighborRow = this.indexRow + i;
                int neighborCol = this.indexCol + j;

                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                    if (gridArray[neighborRow][neighborCol].getAlive()) {
                        livingNeighbors++;
                    }
                }
            }
        }
        
        setNumLivingNeighbors(livingNeighbors);

        decideNextStatus();
    }

    private void decideNextStatus() {
        if (this.alive) {
            if (this.numLivingNeighbors < 2 || this.numLivingNeighbors > 3) {
                setIsAliveNextGen(false);
            } else {
                setIsAliveNextGen(true);
            }
        } else {
            if (this.numLivingNeighbors == 3) {
                setIsAliveNextGen(true);
            } else {
                setIsAliveNextGen(false);
            }
        }
    }
}
