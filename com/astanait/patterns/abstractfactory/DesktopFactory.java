package com.astanait.patterns.abstractfactory;

/**
 * Concrete Factory producing the full "Desktop" family of components.
 */
public final class DesktopFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DesktopButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DesktopCheckbox();
    }
}
