package defpackage;

import defpackage.wv1;
import java.util.Objects;

/* renamed from: rv1  reason: default package */
/* compiled from: AutoValue_BackendResponse */
public final class rv1 extends wv1 {

    /* renamed from: a  reason: collision with root package name */
    public final wv1.a f3136a;
    public final long b;

    public rv1(wv1.a aVar, long j) {
        Objects.requireNonNull(aVar, "Null status");
        this.f3136a = aVar;
        this.b = j;
    }

    @Override // defpackage.wv1
    public long b() {
        return this.b;
    }

    @Override // defpackage.wv1
    public wv1.a c() {
        return this.f3136a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wv1)) {
            return false;
        }
        wv1 wv1 = (wv1) obj;
        if (!this.f3136a.equals(wv1.c()) || this.b != wv1.b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.b;
        return ((this.f3136a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("BackendResponse{status=");
        i0.append(this.f3136a);
        i0.append(", nextRequestWaitMillis=");
        i0.append(this.b);
        i0.append("}");
        return i0.toString();
    }
}
