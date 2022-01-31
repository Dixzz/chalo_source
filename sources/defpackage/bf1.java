package defpackage;

/* renamed from: bf1  reason: default package */
/* compiled from: MTicketPunchedEvent.kt */
public final class bf1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f421a;
    public final String b;
    public final String c;

    public bf1(String str, String str2, String str3) {
        n86.e(str, "notificationTitle");
        n86.e(str2, "notificationSubtitle");
        n86.e(str3, "payload");
        this.f421a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bf1)) {
            return false;
        }
        bf1 bf1 = (bf1) obj;
        return n86.a(this.f421a, bf1.f421a) && n86.a(this.b, bf1.b) && n86.a(this.c, bf1.c);
    }

    public int hashCode() {
        return this.c.hashCode() + hj1.r0(this.b, this.f421a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MTicketPunchedEvent(notificationTitle=");
        i0.append(this.f421a);
        i0.append(", notificationSubtitle=");
        i0.append(this.b);
        i0.append(", payload=");
        return hj1.Z(i0, this.c, ')');
    }
}
