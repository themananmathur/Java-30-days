# Day 8 – Inheritance & Polymorphism

## Learnings
- Inheritance lets child classes reuse and specialize parent behavior.
- Abstract classes define a contract (`Area()`, `Perimeter()`) that subclasses must implement.
- Method overriding lets each shape provide its own logic for area/perimeter.
- Constructors in parent classes must be called with `super(...)` if no default exists.
- Polymorphism: a `Shape[]` can hold Circle, Rectangle, Square, Triangle, DiamondResolved — and the right method runs at runtime.
- Diamond problem: Java avoids multiple class inheritance to prevent ambiguity.
    - Tried extending both `Circle` and `Rectangle` → compile-time error.
    - Resolved using **composition**: `DiamondResolved extends Shape` and holds `Circle` + `Rectangle` inside.

## Hands-on
- Built an abstract `Shape` class with `Area()`, `Perimeter()`, and `describe()`.
- Implemented `Circle`, `Rectangle`, `Square`, `Triangle` with proper overrides.
- Added `Main` class to demo polymorphism by looping through different shapes.
- Added `DiamondResolved` to simulate multiple inheritance using composition.
- Verified everything by compiling and running from terminal.

## Challenges
- Case sensitivity (`Area()` vs `area()`) caused override errors.
- “No-arg constructor not found” → fixed with `super("ShapeName")`.
- Running from terminal: had to compile from `src` and run with full package name (`java -cp . day8.Main`).
- Diamond problem: saw why Java forbids multiple class inheritance, then fixed it with composition.
