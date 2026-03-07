package it.unibo.pps.e2;

public class KnightMoveset implements Moveset {
    @Override
    public boolean checkMove(Pair<Integer, Integer> currentPosition, Pair<Integer, Integer> newPosition) {
        int x = newPosition.getX() - currentPosition.getX();
        int y = newPosition.getY() - currentPosition.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
