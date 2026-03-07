package it.unibo.pps.e2;

import java.util.Random;

public class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;
    private final Random random = new Random();
    private final int size;
    private final Moveset knightMoveset;

    public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition, Moveset knightMoveset) {
        if (pawnPosition == knightPosition) {
            throw new IllegalStateException();
        }
        this.size = size;
        this.pawn = pawnPosition;
        this.knight = knightPosition;
        this.knightMoveset = knightMoveset;
    }

    public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
        this(size, pawnPosition, knightPosition, new KnightMoveset());
    }

    public LogicsImpl(int size) {
        this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
        this.knightMoveset = new KnightMoveset();
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn != null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    private void checkInput(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void moveKnight(Pair<Integer, Integer> newPosition) {
        this.knight = newPosition;
    }

    @Override
    public boolean hit(int row, int col) {
        checkInput(row, col);
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
        if (this.knightMoveset.checkMove(knight, newPosition)) {
            moveKnight(newPosition);
        }
        return this.pawn.equals(this.knight);
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }
}
