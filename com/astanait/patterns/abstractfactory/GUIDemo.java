package com.astanait.patterns.abstractfactory;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Bootstrap/composition root for the Abstract Factory example.
 *
 * Only this entry point knows that "web" maps to {@link WebFactory} and
 * "desktop" maps to {@link DesktopFactory}; {@link Application} itself
 * never sees these concrete names.
 */
public final class GUIDemo {

    private static final Map<String, Supplier<GUIFactory>> FACTORY_REGISTRY = Map.of(
            "web", WebFactory::new,
            "desktop", DesktopFactory::new
    );

    public static void main(String[] args) {
        for (String platform : FACTORY_REGISTRY.keySet()) {
            GUIFactory factory = FACTORY_REGISTRY.get(platform).get();
            Application app = new Application(factory);

            System.out.println("Platform: " + platform);
            System.out.println(app.renderUi());
            System.out.println(app.simulateUserInteraction());
            System.out.println("---");
        }
    }
}
