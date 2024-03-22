package com.hslu.enlab.gameoflife.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CellTests {
    @ParameterizedTest(name = "Cell {0} should have symbol {1}")
    @CsvSource({ "DEAD, ' '", "ALIVE, 'X'" })
    void testGetSymbol(Cell cell, char expectedSymbol) {
        char actualSymbol = cell.getSymbol();
        assertEquals(expectedSymbol, actualSymbol);
    }

    @ParameterizedTest
    @CsvSource({
            "ALIVE, 0, DEAD",
            "ALIVE, 1, DEAD",
            "ALIVE, 2, ALIVE",
            "ALIVE, 3, ALIVE",
            "ALIVE, 4, DEAD",
            "DEAD, 2, DEAD",
            "DEAD, 3, ALIVE",
            "DEAD, 4, DEAD"
    })
    void testNextGeneration(Cell initial, int aliveNeighbours, Cell expected) {
        assertEquals(expected, initial.nextGeneration(aliveNeighbours));
    }

}
