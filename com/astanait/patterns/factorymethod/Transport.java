package com.astanait.patterns.factorymethod;

/**
 * Product interface (Factory Method pattern).
 * Declares the contract that every concrete means of transport must fulfil.
 */
public interface Transport {

    /**
     * Executes the delivery and returns a short human-readable report.
     */
    String deliver(String cargoDescription);

    /**
     * Maximum cargo weight (in tons) this transport can carry in one trip.
     */
    double getCapacityTons();
}
