package com.interview.galaxy.model;

/**
 * Author: Vinh Pham
 * Date: 11/24/16
 * Time: 10:18 PM
 */
public class RomanPair {
    private RomanNumber one;
    private RomanNumber two;

    public RomanPair(RomanNumber one, RomanNumber two) {
        this.one = one;
        this.two = two;
    }

    public RomanNumber getOne() {
        return one;
    }

    public RomanNumber getTwo() {
        return two;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return one.name() + two.name();
    }

    public int operate() {
        return two != null? (two.getValue() >= one.getValue() ? add() : substract()) : one.getValue();
    }

    private int add() {
        return one.getValue() - two.getValue();
    }

    private int substract() {
        return one.getValue() + two.getValue();
    }
}
