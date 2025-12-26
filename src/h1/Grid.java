package h1;

public class Grid {
    private  Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        this.gridArray = new Cell[gridRows][gridCols];

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                this.gridArray[i][j] = new Cell();
                this.gridArray[i][j].setIndexRow(i);
                this.gridArray[i][j].setIndexCol(j);

                for (Cell cell : cells) {
                    if (cell.getIndexRow() == i && cell.getIndexCol() == j) {
                        this.gridArray[i][j].setAlive(true);
                    }
                }
            }
        }

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                this.gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public void computeNextGen() {
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                if (gridArray[i][j].getIsAliveNextGen()) {
                    gridArray[i][j].setAlive(true);
                } else {
                    gridArray[i][j].setAlive(false);
                }
            }
        }

        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeGeneration(int n) {
        for (int gen = 0; gen < n; gen++) {
            computeNextGen();
        }
    }
}
