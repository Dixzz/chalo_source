package defpackage;

/* renamed from: ru1  reason: default package */
/* compiled from: AutoValue_LogResponse */
public final class ru1 extends xu1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f3133a;

    public ru1(long j) {
        this.f3133a = j;
    }

    @Override // defpackage.xu1
    public long b() {
        return this.f3133a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xu1) || this.f3133a != ((xu1) obj).b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f3133a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("LogResponse{nextRequestWaitMillis=");
        i0.append(this.f3133a);
        i0.append("}");
        return i0.toString();
    }
}
