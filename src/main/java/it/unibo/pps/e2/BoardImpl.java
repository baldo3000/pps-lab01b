package it.unibo.pps.e2;

import java.util.Random;

public class BoardImpl implements Board {
    private final Random random = new Random();
    private final int size;
    private final Pair<Integer, Integer> pawnPosition;
    private Pair<Integer, Integer> knightPosition;

    public BoardImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
        if (pawnPosition == knightPosition) {
            throw new IllegalStateException();
        }
        this.size = size;
        this.pawnPosition = pawnPosition;
        this.knightPosition = knightPosition;
    }

    public BoardImpl(int size) {
        this.size = size;
        this.pawnPosition = randomEmptyPosition();
        this.knightPosition = randomEmptyPosition();
    }

    private void checkInput(Pair<Integer, Integer> position) {
        int row = position.getX();
        int col = position.getY();
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void moveKnight(Pair<Integer, Integer> newPosition) {
        checkInput(newPosition);
        this.knightPosition = newPosition;
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawnPosition;
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knightPosition;
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.getPawnPosition() != null && this.getPawnPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
}
