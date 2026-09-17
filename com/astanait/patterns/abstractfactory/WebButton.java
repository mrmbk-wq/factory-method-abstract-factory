package com.astanait.patterns.abstractfactory;

/**
 * Concrete Product: button belonging to the "Web" family.
 */
public final class WebButton implements Button {
    @Override
    public String render() {
        return "<button class=\"web-btn\">Submit</button>";
    }

    @Override
    public String onClick() {
        return "WebButton: dispatched a DOM 'click' event.";
    }
}
