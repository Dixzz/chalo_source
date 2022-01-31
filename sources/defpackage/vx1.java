package defpackage;

/* renamed from: vx1  reason: default package */
/* compiled from: AutoValue_EventStoreConfig */
public final class vx1 extends yx1 {
    public final long b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;

    public vx1(long j, int i, int i2, long j2, int i3, a aVar) {
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }

    @Override // defpackage.yx1
    public int a() {
        return this.d;
    }

    @Override // defpackage.yx1
    public long b() {
        return this.e;
    }

    @Override // defpackage.yx1
    public int c() {
        return this.c;
    }

    @Override // defpackage.yx1
    public int d() {
        return this.f;
    }

    @Override // defpackage.yx1
    public long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yx1)) {
            return false;
        }
        yx1 yx1 = (yx1) obj;
        if (this.b == yx1.e() && this.c == yx1.c() && this.d == yx1.a() && this.e == yx1.b() && this.f == yx1.d()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.e;
        return this.f ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("EventStoreConfig{maxStorageSizeInBytes=");
        i0.append(this.b);
        i0.append(", loadBatchSize=");
        i0.append(this.c);
        i0.append(", criticalSectionEnterTimeoutMs=");
        i0.append(this.d);
        i0.append(", eventCleanUpAge=");
        i0.append(this.e);
        i0.append(", maxBlobByteSizePerRow=");
        return hj1.X(i0, this.f, "}");
    }
}
