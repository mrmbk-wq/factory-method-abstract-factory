package com.astanait.patterns.factorymethod;

/**
 * Concrete Creator: builds trucks with a fixed default capacity.
 */
public final class TruckFactory extends TransportFactory {

    private static final double DEFAULT_CAPACITY_TONS = 10.0;

    @Override
    protected Transport createTransport() {
        return new Truck(DEFAULT_CAPACITY_TONS);
    }
}
