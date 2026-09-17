package com.astanait.patterns.factorymethod;

/**
 * Creator (Factory Method pattern).
 * Declares the factory method {@link #createTransport()} and provides a
 * template method, {@link #planDelivery(String)}, that uses the product
 * without knowing its concrete class.
 */
public abstract class TransportFactory {

    /**
     * The factory method. Each Concrete Creator decides which
     * Concrete Product to instantiate.
     */
    protected abstract Transport createTransport();

    /**
     * Template method: the rest of the class only relies on the
     * {@link Transport} abstraction, never on a concrete class.
     * This is where "no conditional/type-checking logic in client code"
     * is enforced — callers never branch on transport type themselves.
     */
    public final String planDelivery(String cargoDescription) {
        Transport transport = createTransport();
        return transport.deliver(cargoDescription);
    }
}
