package it.unibo.pps.e2;

public class LogicsImpl implements Logics {
    private final Board board;
    private final Moveset knightMoveset;

    public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition, Moveset knightMoveset) {
        if (pawnPosition == knightPosition) {
            throw new IllegalStateException();
        }
        this.board = new BoardImpl(size, pawnPosition, knightPosition);
        this.knightMoveset = knightMoveset;
    }

    public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
        this(size, pawnPosition, knightPosition, new KnightMoveset());
    }

    public LogicsImpl(int size) {
        this.board = new BoardImpl(size);
        this.knightMoveset = new KnightMoveset();
    }

    private void moveKnight(Pair<Integer, Integer> newPosition) {
        if (this.knightMoveset.checkMove(this.board.getKnightPosition(), newPosition)) {
            this.board.moveKnight(newPosition);
        }
    }

    @Override
    public boolean hit(int row, int col) {
        moveKnight(new Pair<>(row, col));
        return this.board.getKnightPosition().equals(this.board.getPawnPosition());
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.board.getKnightPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.board.getPawnPosition().equals(new Pair<>(row, col));
    }
}
