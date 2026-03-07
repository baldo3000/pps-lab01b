package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMovesetTest {
    private static final Pair<Integer, Integer> INITIAL_KNIGHT_POSITION = new Pair<>(2, 2);
    private Moveset moveset;

    @BeforeEach
    public void setup() {
        this.moveset = new KnightMoveset();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "0, 1",
            "0, 3",
            "1, 4",
            "3, 4",
            "4, 3",
            "4, 1",
            "3, 0"
    })
    public void testCorrectMove(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        assertTrue(moveset.checkMove(INITIAL_KNIGHT_POSITION, newPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "4, 4",
            "1, 1",
            "1, 2",
            "2, 1",
            "1000, 2",
            "2, 1000",
    })
    public void testBadMove(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        assertFalse(moveset.checkMove(INITIAL_KNIGHT_POSITION, newPosition));
    }
}
