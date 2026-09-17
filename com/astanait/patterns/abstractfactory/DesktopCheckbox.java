package com.astanait.patterns.abstractfactory;

/**
 * Concrete Product: checkbox belonging to the "Desktop" family.
 */
public final class DesktopCheckbox implements Checkbox {
    private boolean checked = false;

    @Override
    public String render() {
        return "[" + (checked ? "x" : " ") + "] DesktopCheckbox (native widget)";
    }

    @Override
    public String toggle() {
        checked = !checked;
        return "DesktopCheckbox: state is now " + checked + " (native widget repainted).";
    }
}
