# Java `Result` Type (Inspired by `neverthrow` from TypeScript)

This project demonstrates how to implement a custom `Result` type in Java, inspired by the functional error-handling pattern used in TypeScript libraries like [`neverthrow`](https://github.com/supermacro/neverthrow).

---

## Folder Structure

<pre lang="markdown">
src/
├── Main.java
├── models/
│   └── errors/
│       └── UserError.java
├── services/
│   └── user/
│       └── UserService.java
└── types/
    └── result/
        ├── Result.java
        ├── Ok.java
        └── Err.java
</pre>

---

## Purpose

Java doesn't have a built-in `Result<T, E>` type like Rust or TypeScript with `neverthrow`. This project introduces a functional way to **return errors without throwing exceptions**, using types like:

* `Ok<T, E>` – for success
* `Err<T, E>` – for failure
* `Result<T, E>` – the interface that both implement

---

## How It Works

### `Result<T, E>`

An interface that defines:

* `isOk()`
* `isErr()`
* `unwrap()`
* `unwrapErr()`

### `Ok<T, E>`

```Java
//Used to return successful values.
return new Ok<>("Winterson");
Err<T, E>

// Used to return errors without throwing.
return new Err<>(new UserError("User not found", 404));

```

## Example: UserService

```Java

public Result<String, UserError> getUserById(int id) {
    if (id == 1) {
        return new Ok<>("Winterson");
    } else {
        return new Err<>(new UserError("User not found", 404));
    }
}
```

## Running the Project

### `Compile:`

```bash
javac -d out src/**/*.java
java -cp out com.winterson.Main
```

Make sure your Main.java file has the correct package (or adjust as needed).

### Output Example

```Bash
Error [404]: User not found 
```

### Future Improvements

* Add map(), mapErr(), and andThen() methods
* Turn this into a Maven project
* Integrate with a web framework (like Spring Boot)
* Add unit tests
