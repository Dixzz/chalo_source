package defpackage;

import android.os.SystemClock;
import java.util.Objects;

/* renamed from: ee3  reason: default package */
public final class ee3 {

    /* renamed from: a  reason: collision with root package name */
    public final cb2 f965a;
    public long b;

    public ee3(cb2 cb2) {
        Objects.requireNonNull(cb2, "null reference");
        this.f965a = cb2;
    }

    public final void a() {
        Objects.requireNonNull((db2) this.f965a);
        this.b = SystemClock.elapsedRealtime();
    }

    public final boolean b(long j) {
        if (this.b == 0) {
            return true;
        }
        Objects.requireNonNull((db2) this.f965a);
        if (SystemClock.elapsedRealtime() - this.b > j) {
            return true;
        }
        return false;
    }
}
