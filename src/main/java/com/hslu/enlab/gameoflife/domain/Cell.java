package com.hslu.enlab.gameoflife.domain;

public enum Cell {
    DEAD(' '), ALIVE('X');

    private char symbol;

    Cell(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Cell fromSymbol(char symbol) {
        for (Cell cell : Cell.values()) {
            if (cell.symbol == symbol) {
                return cell;
            }
        }
        throw new IllegalArgumentException("Unknown symbol: " + symbol);
    }

    public Cell nextGeneration(int aliveNeighbours) {
        if (this == ALIVE) {
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                return DEAD;
            }
            return ALIVE;
        } else {
            if (aliveNeighbours == 3) {
                return ALIVE;
            }
            return DEAD;
        }
    }
}
