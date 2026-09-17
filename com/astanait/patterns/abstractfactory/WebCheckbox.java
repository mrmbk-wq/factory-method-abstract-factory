package com.astanait.patterns.abstractfactory;

/**
 * Concrete Product: checkbox belonging to the "Web" family.
 */
public final class WebCheckbox implements Checkbox {
    private boolean checked = false;

    @Override
    public String render() {
        return "<input type=\"checkbox\" class=\"web-chk\"" + (checked ? " checked" : "") + "/>";
    }

    @Override
    public String toggle() {
        checked = !checked;
        return "WebCheckbox: state is now " + checked + " (re-rendered via DOM).";
    }
}
