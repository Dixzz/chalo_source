package defpackage;

/* renamed from: hb5  reason: default package */
/* compiled from: InvalidDataException */
public class hb5 extends Exception {
    public int f;

    public hb5(int i) {
        this.f = i;
    }

    public hb5(int i, String str) {
        super(str);
        this.f = i;
    }

    public hb5(int i, Throwable th) {
        super(th);
        this.f = i;
    }
}
