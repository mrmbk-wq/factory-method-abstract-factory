package com.astanait.patterns.factorymethod;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Client for the Factory Method example.
 *
 * The client never instantiates {@link Truck} or {@link Ship} directly and
 * never branches on their type: routing from a route "mode" to a concrete
 * factory is done once, through a registry (a small, single-purpose piece
 * of configuration), not through a switch/if-else chain in business logic.
 */
public final class LogisticsDemo {

    private static final Map<String, Supplier<TransportFactory>> FACTORY_REGISTRY = Map.of(
            "road", TruckFactory::new,
            "sea", ShipFactory::new
    );

    public static void main(String[] args) {
        List<String> routes = List.of("road", "sea");

        for (String route : routes) {
            TransportFactory factory = FACTORY_REGISTRY.get(route).get();
            String report = factory.planDelivery("Order #" + route.hashCode());
            System.out.println(report);
        }
    }
}
