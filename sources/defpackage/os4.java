package defpackage;

/* renamed from: os4  reason: default package */
public final class os4 extends RuntimeException {
    public final int f;

    public os4(String str) {
        super(str);
        this.f = -1;
    }

    public os4(String str, int i) {
        super(str);
        this.f = i;
    }

    public os4(String str, Exception exc) {
        super(str, exc);
        this.f = -1;
    }

    public os4(String str, Exception exc, int i) {
        super(str, exc);
        this.f = i;
    }
}
