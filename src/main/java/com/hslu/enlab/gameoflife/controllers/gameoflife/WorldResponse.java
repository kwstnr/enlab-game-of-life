package com.hslu.enlab.gameoflife.controllers.gameoflife;

import java.util.List;

import com.hslu.enlab.gameoflife.domain.Cell;

public class WorldResponse {
    private List<String> rows;

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public WorldResponse(List<String> rows) {
        this.rows = rows;
    }

    public WorldResponse(Cell[][] cells) {
        toRows(cells);
    }

    public void toRows(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < cells[i].length; j++) {
                row.append(cells[i][j].getSymbol());
            }
            rows.add(row.toString());
        }
    }
}
