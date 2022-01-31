package defpackage;

/* renamed from: s75  reason: default package */
/* compiled from: DecodedNumeric */
public final class s75 extends t75 {
    public final int b;
    public final int c;

    public s75(int i, int i2, int i3) throws v25 {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw v25.a();
        }
        this.b = i2;
        this.c = i3;
    }
}
