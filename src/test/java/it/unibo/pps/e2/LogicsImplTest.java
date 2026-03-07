package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicsImplTest {
    private static final int TEST_SIZE = 5;
    private static final Pair<Integer, Integer> INITIAL_PAWN_POSITION = new Pair<>(1, 3);
    private static final Pair<Integer, Integer> INITIAL_KNIGHT_POSITION = new Pair<>(3, 4);
    private Logics logics;

    @BeforeEach
    public void setup() {
        this.logics = new LogicsImpl(TEST_SIZE, INITIAL_PAWN_POSITION, INITIAL_KNIGHT_POSITION);
    }

    @Test
    public void testCorrectPawnInitialPosition() {
        assertTrue(this.logics.hasPawn(INITIAL_PAWN_POSITION.getX(), INITIAL_PAWN_POSITION.getY()));
    }

    @Test
    public void testWrongPawnInitialPosition() {
        int fakeDelta = 1;
        assertFalse(this.logics.hasPawn(INITIAL_PAWN_POSITION.getX() + fakeDelta, INITIAL_PAWN_POSITION.getY()));
    }

    @Test
    public void testCorrectKnightInitialPosition() {
        assertTrue(this.logics.hasKnight(INITIAL_KNIGHT_POSITION.getX(), INITIAL_KNIGHT_POSITION.getY()));
    }

    @Test
    public void testWrongKnightInitialPosition() {
        int fakeDelta = 1;
        assertFalse(this.logics.hasKnight(INITIAL_KNIGHT_POSITION.getX() + fakeDelta, INITIAL_KNIGHT_POSITION.getY()));
    }

    @Test
    public void testKnightHittingPawn() {
        assertTrue(this.logics.hit(INITIAL_PAWN_POSITION.getX(), INITIAL_PAWN_POSITION.getY()));
    }

    @Test
    public void testKnightNotHittingPawn() {
        int baseX = INITIAL_PAWN_POSITION.getX();
        int fakeDelta = baseX < TEST_SIZE ? baseX + 1 : baseX - 1;
        assertFalse(this.logics.hit(INITIAL_PAWN_POSITION.getX() + fakeDelta, INITIAL_PAWN_POSITION.getY()));
    }

    @Test
    public void testKnightMovingCorrectly() {
        int newX = 2;
        int newY = 2;
        this.logics.hit(newX, newY);
        assertTrue(this.logics.hasKnight(newX, newY));
    }

    @Test
    public void testKnightMovingIncorrectly() {
        int newX = 2;
        int newY = 3;
        this.logics.hit(newX, newY);
        assertFalse(this.logics.hasKnight(newX, newY));
    }
}
