package defpackage;

/* renamed from: pf1  reason: default package */
/* compiled from: RecentDestination */
public class pf1 {

    /* renamed from: a  reason: collision with root package name */
    public mf1 f2797a;
    public long b;

    public pf1(mf1 mf1, long j) {
        this.f2797a = mf1;
        this.b = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof pf1)) {
            return false;
        }
        pf1 pf1 = (pf1) obj;
        if (pf1.b != this.b || !pf1.f2797a.equals(this.f2797a)) {
            return false;
        }
        return true;
    }
}
