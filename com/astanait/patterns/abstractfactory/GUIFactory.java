package com.astanait.patterns.abstractfactory;

/**
 * Abstract Factory. Declares one creation method per product type in the
 * family, guaranteeing that whatever concrete family gets chosen, its
 * products are always used together consistently.
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
