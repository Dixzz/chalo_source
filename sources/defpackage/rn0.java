package defpackage;

/* renamed from: rn0  reason: default package */
/* compiled from: ZophopOrderedDialog */
public class rn0 implements Comparable<rn0> {
    public final int f;
    public final om0 g;

    public rn0(int i, om0 om0) {
        this.f = i;
        this.g = om0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(rn0 rn0) {
        return rn0.f - this.f;
    }
}
