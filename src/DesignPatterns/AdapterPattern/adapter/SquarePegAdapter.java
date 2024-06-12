package DesignPatterns.AdapterPattern.adapter;

import DesignPatterns.AdapterPattern.round.RoundPeg;
import DesignPatterns.AdapterPattern.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;
    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double width = peg.getWidth();
        return width / Math.sqrt(2);
    }
}
