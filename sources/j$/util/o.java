package j$.util;

import a.C0073a;
import java.util.NoSuchElementException;

public final class o {
    private static final o c = new o();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1684a;
    private final double b;

    private o() {
        this.f1684a = false;
        this.b = Double.NaN;
    }

    private o(double d) {
        this.f1684a = true;
        this.b = d;
    }

    public static o a() {
        return c;
    }

    public static o d(double d) {
        return new o(d);
    }

    public double b() {
        if (this.f1684a) {
            return this.b;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f1684a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        boolean z = this.f1684a;
        if (!z || !oVar.f1684a) {
            if (z == oVar.f1684a) {
                return true;
            }
        } else if (Double.compare(this.b, oVar.b) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f1684a) {
            return C0073a.a(this.b);
        }
        return 0;
    }

    public String toString() {
        if (!this.f1684a) {
            return "OptionalDouble.empty";
        }
        return String.format("OptionalDouble[%s]", Double.valueOf(this.b));
    }
}
