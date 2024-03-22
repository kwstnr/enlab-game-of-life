package com.hslu.enlab.gameoflife.domain;

public class World {
    private Cell[][] cells;

    public World(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void nextGeneration() {
        Cell[][] nextGeneration = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                nextGeneration[i][j] = cells[i][j].nextGeneration(getAliveNeighbours(i, j));
            }
        }
        cells = nextGeneration;
    }

    private int getAliveNeighbours(int i, int j) {
        int aliveNeighbours = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < cells.length && y >= 0 && y < cells[x].length && (x != i || y != j)
                        && cells[x][y] == Cell.ALIVE) {
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }
}
