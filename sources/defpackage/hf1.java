package defpackage;

/* renamed from: hf1  reason: default package */
/* compiled from: SuperPassPunchEvent.kt */
public final class hf1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1364a;
    public final String b;
    public final String c;

    public hf1(String str, String str2, String str3) {
        n86.e(str, "notificationTitle");
        n86.e(str2, "notificationSubtitle");
        n86.e(str3, "payload");
        this.f1364a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hf1)) {
            return false;
        }
        hf1 hf1 = (hf1) obj;
        return n86.a(this.f1364a, hf1.f1364a) && n86.a(this.b, hf1.b) && n86.a(this.c, hf1.c);
    }

    public int hashCode() {
        return this.c.hashCode() + hj1.r0(this.b, this.f1364a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassPunchEvent(notificationTitle=");
        i0.append(this.f1364a);
        i0.append(", notificationSubtitle=");
        i0.append(this.b);
        i0.append(", payload=");
        return hj1.Z(i0, this.c, ')');
    }
}
