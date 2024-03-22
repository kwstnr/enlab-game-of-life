package com.hslu.enlab.gameoflife.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WorldTest {

    private static Stream<Arguments> provideTestCasesForNextGeneration() {
        return Stream.of(
                Arguments.of(
                        new Cell[][] {
                                { Cell.DEAD, Cell.DEAD, Cell.DEAD },
                                { Cell.ALIVE, Cell.ALIVE, Cell.ALIVE },
                                { Cell.DEAD, Cell.DEAD, Cell.DEAD }
                        },
                        new Cell[][] {
                                { Cell.DEAD, Cell.ALIVE, Cell.DEAD },
                                { Cell.DEAD, Cell.ALIVE, Cell.DEAD },
                                { Cell.DEAD, Cell.ALIVE, Cell.DEAD }
                        }),
                Arguments.of(
                        new Cell[][] {
                                { Cell.ALIVE, Cell.ALIVE },
                                { Cell.ALIVE, Cell.ALIVE }
                        },
                        new Cell[][] {
                                { Cell.ALIVE, Cell.ALIVE },
                                { Cell.ALIVE, Cell.ALIVE }
                        }),
                Arguments.of(
                        new Cell[][] {
                                { Cell.DEAD, Cell.ALIVE, Cell.DEAD },
                                { Cell.DEAD, Cell.ALIVE, Cell.DEAD },
                                { Cell.DEAD, Cell.ALIVE, Cell.DEAD }
                        },
                        new Cell[][] {
                                { Cell.DEAD, Cell.DEAD, Cell.DEAD },
                                { Cell.ALIVE, Cell.ALIVE, Cell.ALIVE },
                                { Cell.DEAD, Cell.DEAD, Cell.DEAD }
                        }));
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForNextGeneration")
    void testNextGeneration(Cell[][] initial, Cell[][] expected) {
        World world = new World(initial);
        world.nextGeneration();
        Cell[][] result = world.getCells();
        assertTrue(Arrays.deepEquals(result, expected));
    }
}
