package defpackage;

/* renamed from: gf1  reason: default package */
/* compiled from: SuperPassApplicationUpdatedEvent.kt */
public final class gf1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1253a;
    public final String b;
    public final String c;

    public gf1(String str, String str2, String str3) {
        n86.e(str, "notificationTitle");
        n86.e(str2, "notificationSubtitle");
        n86.e(str3, "notificationInfo");
        this.f1253a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gf1)) {
            return false;
        }
        gf1 gf1 = (gf1) obj;
        return n86.a(this.f1253a, gf1.f1253a) && n86.a(this.b, gf1.b) && n86.a(this.c, gf1.c);
    }

    public int hashCode() {
        return this.c.hashCode() + hj1.r0(this.b, this.f1253a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassApplicationUpdatedEvent(notificationTitle=");
        i0.append(this.f1253a);
        i0.append(", notificationSubtitle=");
        i0.append(this.b);
        i0.append(", notificationInfo=");
        return hj1.Z(i0, this.c, ')');
    }
}
