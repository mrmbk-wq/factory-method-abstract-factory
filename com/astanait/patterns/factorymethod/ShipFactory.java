package com.astanait.patterns.factorymethod;

/**
 * Concrete Creator: builds ships with a fixed default capacity.
 */
public final class ShipFactory extends TransportFactory {

    private static final double DEFAULT_CAPACITY_TONS = 5000.0;

    @Override
    protected Transport createTransport() {
        return new Ship(DEFAULT_CAPACITY_TONS);
    }
}
