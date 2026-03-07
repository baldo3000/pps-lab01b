package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardImplTest {
    private static final int TEST_SIZE = 5;
    private static final Pair<Integer, Integer> INITIAL_PAWN_POSITION = new Pair<>(1, 3);
    private static final Pair<Integer, Integer> INITIAL_KNIGHT_POSITION = new Pair<>(3, 4);
    private Board board;

    @BeforeEach
    public void setup() {
        this.board = new BoardImpl(TEST_SIZE, INITIAL_PAWN_POSITION, INITIAL_KNIGHT_POSITION);
    }

    @Test
    public void testInitialPositionsColliding() {
        assertThrows(IllegalStateException.class, () -> new LogicsImpl(TEST_SIZE, INITIAL_PAWN_POSITION, INITIAL_PAWN_POSITION));
    }

    @Test
    public void testCorrectPawnInitialPosition() {
        assertEquals(INITIAL_PAWN_POSITION, this.board.getPawnPosition());
    }

    @Test
    public void testWrongPawnInitialPosition() {
        Pair<Integer, Integer> fakePosition = new Pair<>(INITIAL_PAWN_POSITION.getX() + 1, INITIAL_PAWN_POSITION.getY());
        assertNotEquals(fakePosition, this.board.getPawnPosition());
    }

    @Test
    public void testCorrectKnightInitialPosition() {
        assertEquals(INITIAL_KNIGHT_POSITION, this.board.getKnightPosition());
    }

    @Test
    public void testWrongKnightInitialPosition() {
        Pair<Integer, Integer> fakePosition = new Pair<>(INITIAL_KNIGHT_POSITION.getX() + 1, INITIAL_KNIGHT_POSITION.getY());
        assertNotEquals(fakePosition, this.board.getKnightPosition());
    }

    @Test
    public void testMoveKnightCorrectPosition() {
        Pair<Integer, Integer> newPosition = new Pair<>(0, 0);
        this.board.moveKnight(newPosition);
        assertEquals(newPosition, this.board.getKnightPosition());
    }

    @Test
    public void testMoveKnightInCorrectPosition() {
        Pair<Integer, Integer> newPosition = new Pair<>(TEST_SIZE, TEST_SIZE);
        assertThrows(IndexOutOfBoundsException.class, () -> this.board.moveKnight(newPosition));
    }
}
