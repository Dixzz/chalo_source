package j$.util;

import j$.time.chrono.b;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional<T> {
    private static final Optional b = new Optional();

    /* renamed from: a  reason: collision with root package name */
    private final Object f1646a;

    private Optional() {
        this.f1646a = null;
    }

    private Optional(Object obj) {
        Objects.requireNonNull(obj);
        this.f1646a = obj;
    }

    public static Optional a() {
        return b;
    }

    public static Optional d(Object obj) {
        return new Optional(obj);
    }

    public static Optional ofNullable(Object obj) {
        return obj == null ? b : new Optional(obj);
    }

    public Object b() {
        Object obj = this.f1646a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f1646a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        return b.x(this.f1646a, ((Optional) obj).f1646a);
    }

    public int hashCode() {
        Object obj = this.f1646a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f1646a;
        if (obj == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", obj);
    }
}
