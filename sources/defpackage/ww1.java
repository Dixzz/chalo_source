package defpackage;

import defpackage.zw1;
import java.util.Map;
import java.util.Objects;

/* renamed from: ww1  reason: default package */
/* compiled from: AutoValue_SchedulerConfig */
public final class ww1 extends zw1 {

    /* renamed from: a  reason: collision with root package name */
    public final jy1 f3847a;
    public final Map<bu1, zw1.a> b;

    public ww1(jy1 jy1, Map<bu1, zw1.a> map) {
        Objects.requireNonNull(jy1, "Null clock");
        this.f3847a = jy1;
        Objects.requireNonNull(map, "Null values");
        this.b = map;
    }

    @Override // defpackage.zw1
    public jy1 a() {
        return this.f3847a;
    }

    @Override // defpackage.zw1
    public Map<bu1, zw1.a> c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zw1)) {
            return false;
        }
        zw1 zw1 = (zw1) obj;
        if (!this.f3847a.equals(zw1.a()) || !this.b.equals(zw1.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f3847a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SchedulerConfig{clock=");
        i0.append(this.f3847a);
        i0.append(", values=");
        i0.append(this.b);
        i0.append("}");
        return i0.toString();
    }
}
