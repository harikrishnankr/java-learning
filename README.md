# Java Tutorials — Senior Developer Curriculum

A pure-Java (no Spring, no frameworks) learning codebase, one package per
topic, organized into five themed batches under `com.tutorials`. Every class
is meant to be read, run, and modified — that's the point of keeping it all
in one project instead of scattered snippets.

## Requirements

- JDK 21 (`java -version`)
- Maven 3.9+ (`mvn -version`)

## Getting started

```bash
mvn compile        # compile everything
mvn test           # run tests (currently: the "testing" topic's own suite)
```

There's no `main` entry point by design — this is a library of standalone
topics, not an app. Open any class, read it, and run its logic from your
own `main` method, a scratch file, or (recommended) tests you write
yourself under `src/test/java` as you go.

## Curriculum checklist

Work through top to bottom. Once you've read the code, run it yourself, and
(ideally) written a test or two against it, mark it done by replacing that
line's ☐ with ☑ (or just delete the ☐). Progress is just you editing this
file — nothing else reads these marks.

### 1. `com.tutorials.core` — Core OOP & modern type features

- ☑ ~~**oop.encapsulation** — Invariant-protecting fields, defensive copies — [folder](src/main/java/com/tutorials/core/oop/encapsulation)~~
- ☑ ~~**oop.inheritance** — `extends`, `super`, constructor chaining, static method hiding vs. overriding — [folder](src/main/java/com/tutorials/core/oop/inheritance)~~
- ☐ **oop.interfaces** — Default/static/private interface methods, diamond conflict resolution — [folder](src/main/java/com/tutorials/core/oop/interfaces)
- ☐ **oop.abstraction** — Abstract classes, the Template Method pattern — [folder](src/main/java/com/tutorials/core/oop/abstraction)
- ☐ **oop.polymorphism** — Dynamic dispatch vs. compile-time overload resolution, covariant returns — [folder](src/main/java/com/tutorials/core/oop/polymorphism)
- ☐ **records** — Canonical/compact constructors, record patterns — [folder](src/main/java/com/tutorials/core/records)
- ☐ **sealed** — Sealed interfaces/classes, exhaustive pattern-matching switch — [folder](src/main/java/com/tutorials/core/sealed)
- ☐ **enums** — Constant-specific method bodies, `EnumMap`/`EnumSet` — [folder](src/main/java/com/tutorials/core/enums)
- ☐ **objectcontracts** — `equals`/`hashCode`/`toString`/`Comparable`, the mutable-hash-key pitfall — [folder](src/main/java/com/tutorials/core/objectcontracts)
- ☐ **exceptions** — Checked vs. unchecked, try-with-resources, suppressed exceptions, chaining — [folder](src/main/java/com/tutorials/core/exceptions)

### 2. `com.tutorials.functional` — Generics, functional programming & collections

- ☐ **generics** — Bounded types, wildcards (PECS), generic methods, type erasure — [folder](src/main/java/com/tutorials/functional/generics)
- ☐ **lambdas** — Functional interfaces, all four method reference forms, closures — [folder](src/main/java/com/tutorials/functional/lambdas)
- ☐ **streams** — Stream pipelines, `Collectors`, parallel streams — [folder](src/main/java/com/tutorials/functional/streams)
- ☐ **optional** — `Optional` as a return-only tool: `map`/`flatMap`/`orElseThrow` — [folder](src/main/java/com/tutorials/functional/optional)
- ☐ **collections** — Choosing `ArrayList`/`ArrayDeque`/`TreeSet`/`TreeMap`/etc. deliberately — [folder](src/main/java/com/tutorials/functional/collections)
- ☐ **collections.custom** — An LRU cache via `LinkedHashMap`, a custom `Iterable` — [folder](src/main/java/com/tutorials/functional/collections/custom)
- ☐ **immutability** — `final` + defensive copies, "mutation" as returning a new instance — [folder](src/main/java/com/tutorials/functional/immutability)

### 3. `com.tutorials.language` — Modern Java, strings, time, regex

- ☐ **patternmatching** — `switch` patterns, guards, `case null`, nested record patterns — [folder](src/main/java/com/tutorials/language/patternmatching)
- ☐ **strings** — String pool/interning, `StringBuilder` vs. `+=`, text blocks — [folder](src/main/java/com/tutorials/language/strings)
- ☐ **datetime** — `java.time`: `LocalDate`, `Duration`, `Period`, `ZonedDateTime` — [folder](src/main/java/com/tutorials/language/datetime)
- ☐ **regex** — `Pattern`/`Matcher`, named groups, replace/extract recipes — [folder](src/main/java/com/tutorials/language/regex)
- ☐ **typeinference** — `var`, varargs, autoboxing pitfalls (Integer cache, unboxing NPE) — [folder](src/main/java/com/tutorials/language/typeinference)

### 4. `com.tutorials.systems` — Concurrency & I/O

- ☐ **concurrency.threads** — Race conditions, `synchronized`, manual `wait`/`notifyAll` — [folder](src/main/java/com/tutorials/systems/concurrency/threads)
- ☐ **concurrency.executors** — `ExecutorService`, `Future`, `invokeAll` — [folder](src/main/java/com/tutorials/systems/concurrency/executors)
- ☐ **concurrency.advanced** — `Atomic*`/CAS, `ReentrantLock`, `CompletableFuture`, concurrent collections — [folder](src/main/java/com/tutorials/systems/concurrency/advanced)
- ☐ **concurrency.virtualthreads** — Java 21 virtual threads — [folder](src/main/java/com/tutorials/systems/concurrency/virtualthreads)
- ☐ **io** — Decorator-style `java.io` streams over in-memory sources — [folder](src/main/java/com/tutorials/systems/io)
- ☐ **nio** — `java.nio.file` `Path`/`Files` — [folder](src/main/java/com/tutorials/systems/nio)

### 5. `com.tutorials.advanced` — Reflection, design patterns, testing, networking

- ☐ **reflection** — Custom annotations processed at runtime, `Field`/`Method` access — [folder](src/main/java/com/tutorials/advanced/reflection)
- ☐ **designpatterns.creational** — Enum singleton, lazy holder singleton, factory method, builder — [folder](src/main/java/com/tutorials/advanced/designpatterns/creational)
- ☐ **designpatterns.structural** — Adapter, decorator, (virtual) proxy — [folder](src/main/java/com/tutorials/advanced/designpatterns/structural)
- ☐ **designpatterns.behavioral** — Strategy, observer, command (with undo) — [folder](src/main/java/com/tutorials/advanced/designpatterns/behavioral)
- ☐ **testing** — JUnit 5 itself: lifecycle, parameterized tests, nested tests, assumptions — [folder](src/main/java/com/tutorials/advanced/testing) (test class: [here](src/test/java/com/tutorials/advanced/testing))
- ☐ **networking** — Blocking sockets, `java.net.http.HttpClient` — [folder](src/main/java/com/tutorials/advanced/networking)

## Project layout

Standard Maven layout: `src/main/java` for topic code, `src/test/java` for
tests. The only dependency is JUnit 5 (test scope) — add your own tests
under `src/test/java/com/tutorials/...` as you work through each topic.
