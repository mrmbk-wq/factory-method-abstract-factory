package com.astanait.patterns.factorymethod;

/**
 * Concrete Product: sea transport.
 */
public final class Ship implements Transport {

    private final double capacityTons;

    public Ship(double capacityTons) {
        if (capacityTons <= 0) {
            throw new IllegalArgumentException("Ship capacity must be positive, got: " + capacityTons);
        }
        this.capacityTons = capacityTons;
    }

    @Override
    public String deliver(String cargoDescription) {
        return "Ship: delivering '" + cargoDescription + "' by sea (capacity "
                + capacityTons + "t).";
    }

    @Override
    public double getCapacityTons() {
        return capacityTons;
    }
}
