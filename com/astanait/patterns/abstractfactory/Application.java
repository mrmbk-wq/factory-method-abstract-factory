package com.astanait.patterns.abstractfactory;

/**
 * Client. Works only through {@link GUIFactory}, {@link Button} and
 * {@link Checkbox} — it never references WebButton, DesktopCheckbox, etc.,
 * and contains no type-checking or branching on the concrete family.
 */
public final class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        // Consistent, validated construction: a full, matching family is
        // built once, in the constructor, so the object is never left in a
        // half-initialized/mismatched state.
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public String renderUi() {
        return button.render() + System.lineSeparator() + checkbox.render();
    }

    public String simulateUserInteraction() {
        return button.onClick() + System.lineSeparator() + checkbox.toggle();
    }
}
