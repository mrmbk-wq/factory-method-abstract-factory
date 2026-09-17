package com.astanait.patterns.abstractfactory;

/**
 * Concrete Factory producing the full "Web" family of components.
 */
public final class WebFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WebButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WebCheckbox();
    }
}
