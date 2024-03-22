package com.hslu.enlab.gameoflife.controllers.gameoflife;

import java.util.List;

import com.hslu.enlab.gameoflife.domain.Cell;

public class WorldDto {
    private List<String> rows;

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public WorldDto(List<String> rows) {
        this.rows = rows;
    }

    public Cell[][] toCells() {
        Cell[][] cells = new Cell[rows.size()][rows.get(0).length()];
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).length(); j++) {
                cells[i][j] = rows.get(i).charAt(j) == 'X' ? Cell.ALIVE : Cell.DEAD;
            }
        }
        return cells;
    }
}
