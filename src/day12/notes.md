# Day 12 – Packages & Modifiers

## Learnings
- Learned how **packages** organize code into folder structures and help with modularity.
- Understood **access modifiers**:
    - `public` – visible everywhere
    - `private` – visible only within the class
    - *default/package-private* – visible only inside the same package
    - `protected` – visible in same package + subclasses
- Practiced using other modifiers:
    - `static` – class-level members
    - `final` – immutability and preventing changes
- Realized how modifiers help with **data hiding, API design, and code clarity**.

## Hands-on
- Built a package-based project with `app`, `models`, and `utils`.
- `Person` class: `private final name` with a public getter.
- `Helper` class: public static method to print greetings.
- `InternalUtil`: package-private class only accessible within `utils`.
