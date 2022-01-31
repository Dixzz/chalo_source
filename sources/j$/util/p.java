package j$.util;

import java.util.NoSuchElementException;

public final class p {
    private static final p c = new p();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1685a;
    private final int b;

    private p() {
        this.f1685a = false;
        this.b = 0;
    }

    private p(int i) {
        this.f1685a = true;
        this.b = i;
    }

    public static p a() {
        return c;
    }

    public static p d(int i) {
        return new p(i);
    }

    public int b() {
        if (this.f1685a) {
            return this.b;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f1685a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        boolean z = this.f1685a;
        if (!z || !pVar.f1685a) {
            if (z == pVar.f1685a) {
                return true;
            }
        } else if (this.b == pVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f1685a) {
            return this.b;
        }
        return 0;
    }

    public String toString() {
        if (!this.f1685a) {
            return "OptionalInt.empty";
        }
        return String.format("OptionalInt[%s]", Integer.valueOf(this.b));
    }
}
