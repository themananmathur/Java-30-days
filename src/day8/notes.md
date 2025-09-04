# Day 8 – Inheritance & Polymorphism

## Learnings
- Inheritance lets child classes reuse and specialize parent behavior.
- Abstract classes define a contract (`Area()`, `Perimeter()`) that subclasses must implement.
- Method overriding lets each shape provide its own logic for area/perimeter.
- Constructors in parent classes must be called with `super(...)` if no default exists.
- Polymorphism: a `Shape[]` can hold Circle, Rectangle, Square, Triangle — and the right method runs at runtime.
- Diamond problem: Java avoids multiple class inheritance to prevent ambiguity. If needed, use composition.

## Hands-on
- Built an abstract `Shape` class with `Area()`, `Perimeter()`, and `describe()`.
- Implemented `Circle`, `Rectangle`, `Square`, `Triangle` with proper overrides.
- Created a `Main` class to demo polymorphism by looping through different shapes.
- Added `main` methods inside each shape to run them individually.
- Tried simulating the diamond problem → compile-time error, resolved using composition.

## Challenges
- Case sensitivity (`Area()` vs `area()`) caused override errors.
- “No-arg constructor not found” → fixed with `super("ShapeName")`.
- Running from terminal: had to compile from `src` and run with full package name (`java -cp . day8.Main`).
- Accidentally tried `java Circle.java` inside the package → doesn’t work with packaged code.
