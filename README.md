[README.md](https://github.com/user-attachments/files/32318734/README.md)
# Assignment 2 — Factory Method & Abstract Factory

**Course:** ShP-2216 – Software Design Patterns (OP 6B06102)
**Topic:** Option A — Logistics/Transport (Factory Method) → GUI Toolkit (Abstract Factory)

## Structure

```
src/com/astanait/patterns/
├── factorymethod/           # Part A
│   ├── Transport.java        # Product
│   ├── Truck.java             # Concrete Product
│   ├── Ship.java               # Concrete Product
│   ├── TransportFactory.java   # Creator (declares the factory method)
│   ├── TruckFactory.java        # Concrete Creator
│   ├── ShipFactory.java          # Concrete Creator
│   └── LogisticsDemo.java         # Client / entry point
│
└── abstractfactory/          # Part B
    ├── Button.java             # Abstract Product 1
    ├── Checkbox.java            # Abstract Product 2
    ├── WebButton.java             # Concrete Product (Web family)
    ├── WebCheckbox.java            # Concrete Product (Web family)
    ├── DesktopButton.java           # Concrete Product (Desktop family)
    ├── DesktopCheckbox.java          # Concrete Product (Desktop family)
    ├── GUIFactory.java                # Abstract Factory
    ├── WebFactory.java                 # Concrete Factory (Web)
    ├── DesktopFactory.java              # Concrete Factory (Desktop)
    ├── Application.java                  # Client (depends only on abstractions)
    └── GUIDemo.java                        # Bootstrap / composition root
```

## How to run

Requires JDK 17+.

```bash
# from the project root
javac -d out $(find src -name "*.java")
java -cp out com.astanait.patterns.factorymethod.LogisticsDemo
java -cp out com.astanait.patterns.abstractfactory.GUIDemo
```

Or open the folder as a project in IntelliJ IDEA and run `LogisticsDemo` / `GUIDemo` directly.

## Why Factory Method for Part A

Part A has **one product hierarchy** (`Transport`) and the only decision to make
is *which single concrete product* to create (`Truck` or `Ship`). Factory Method
is the right fit: a `Creator` declares a factory method, and each `ConcreteCreator`
overrides it to return one specific product. The client (`LogisticsDemo`) never
sees `Truck`/`Ship` directly — it only calls `TransportFactory.planDelivery(...)`.

## Why Abstract Factory for Part B

Part B needs a **family of related objects** (`Button` + `Checkbox`) that must
stay consistent with each other (all "Web" or all "Desktop", never mixed).
Abstract Factory is the right fit: `GUIFactory` declares one creation method
per product type, and each `ConcreteFactory` (`WebFactory`, `DesktopFactory`)
guarantees the whole family is produced together. `Application` (the client)
depends only on `GUIFactory`, `Button`, and `Checkbox` — never on a concrete
class — so a whole platform's UI can be swapped by swapping one factory.

## Clean Code principles applied

1. **Meaningful, role-revealing names** — `Transport`/`TransportFactory`,
   `GUIFactory`/`Button`/`Checkbox` make the Product vs. Creator/Factory role
   obvious at a glance; no `Manager`/`Helper`/`Data` noise words.
2. **No conditional/type-checking logic in client code** — `LogisticsDemo`
   and `Application` never contain an `if`/`switch` on a transport or
   platform type; polymorphism replaces branching. The one place a string
   ("road"/"sea", "web"/"desktop") is mapped to a class is an immutable
   `Map<String, Supplier<...>>` registry in the composition root, not
   business logic.
3. **Small, single-purpose factory methods** — every `createTransport()`,
   `createButton()`, `createCheckbox()` does exactly one thing: build and
   return one object. No method mixes creation with business logic.
4. **No duplicated object-assembly logic between concrete factories** —
   `WebFactory` and `DesktopFactory` each just `new` their own family;
   the shared assembly sequence (build button, build checkbox) lives once,
   in `Application`'s constructor, not copy-pasted per factory.
5. **Consistent, validated object construction** — `Truck`/`Ship` validate
   `capacityTons > 0` in their constructors, and `Application`'s
   constructor rejects a `null` factory and builds its whole family in one
   place, so no half-initialized object can exist.

## Note on this submission

This repository was scaffolded outside an IDE, so the sandbox used to write
it has a Java **runtime** but no bundled `javac`. The code was written and
reviewed carefully for correctness but has not been compiled in this
environment — please do a clean `javac`/IntelliJ build before pushing, and
attach the actual GitHub link and UML diagrams (see `docs/report-outline.md`)
to your Moodle submission.
