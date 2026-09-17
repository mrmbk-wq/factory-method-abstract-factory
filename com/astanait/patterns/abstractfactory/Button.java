package com.astanait.patterns.abstractfactory;

/**
 * Abstract Product: a button, one of the product types in the family.
 */
public interface Button {
    String render();

    String onClick();
}
