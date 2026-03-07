package it.unibo.pps.e2;

@FunctionalInterface
public interface Moveset {
    boolean checkMove(Pair<Integer, Integer> currentPosition, Pair<Integer, Integer> newPosition);
}
