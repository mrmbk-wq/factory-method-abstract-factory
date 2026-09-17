package com.astanait.patterns.abstractfactory;

/**
 * Concrete Product: button belonging to the "Desktop" family.
 */
public final class DesktopButton implements Button {
    @Override
    public String render() {
        return "[ DesktopButton: Submit ] (native widget)";
    }

    @Override
    public String onClick() {
        return "DesktopButton: fired a native WM_COMMAND event.";
    }
}


