package com.astanait.patterns.factorymethod;

/**
 * Concrete Product: road transport.
 */
public final class Truck implements Transport {

    private final double capacityTons;

    public Truck(double capacityTons) {
        // Consistent, validated object construction (Clean Code principle #5).
        if (capacityTons <= 0) {
            throw new IllegalArgumentException("Truck capacity must be positive, got: " + capacityTons);
        }
        this.capacityTons = capacityTons;
    }

    @Override
    public String deliver(String cargoDescription) {
        return "Truck: delivering '" + cargoDescription + "' by road (capacity "
                + capacityTons + "t).";
    }

    @Override
    public double getCapacityTons() {
        return capacityTons;
    }
}
