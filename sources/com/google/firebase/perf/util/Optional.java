package com.google.firebase.perf.util;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    private Optional() {
        this.value = null;
    }

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    public static <T> Optional<T> of(T t) {
        return new Optional<>(t);
    }

    public static <T> Optional<T> ofNullable(T t) {
        return t == null ? empty() : of(t);
    }

    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean isPresent() {
        return this.value != null;
    }

    private Optional(T t) {
        Objects.requireNonNull(t, "value for optional is empty.");
        this.value = t;
    }
}
