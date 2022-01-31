package j$.util;

import a.C0075b;
import java.util.NoSuchElementException;

public final class q {
    private static final q c = new q();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1686a;
    private final long b;

    private q() {
        this.f1686a = false;
        this.b = 0;
    }

    private q(long j) {
        this.f1686a = true;
        this.b = j;
    }

    public static q a() {
        return c;
    }

    public static q d(long j) {
        return new q(j);
    }

    public long b() {
        if (this.f1686a) {
            return this.b;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f1686a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        boolean z = this.f1686a;
        if (!z || !qVar.f1686a) {
            if (z == qVar.f1686a) {
                return true;
            }
        } else if (this.b == qVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f1686a) {
            return C0075b.a(this.b);
        }
        return 0;
    }

    public String toString() {
        if (!this.f1686a) {
            return "OptionalLong.empty";
        }
        return String.format("OptionalLong[%s]", Long.valueOf(this.b));
    }
}
