package it.unibo.pps.e2;

public interface Board {
    void moveKnight(Pair<Integer, Integer> newPosition);

    Pair<Integer, Integer> getPawnPosition();

    Pair<Integer, Integer> getKnightPosition();
}
