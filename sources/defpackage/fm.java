package defpackage;

/* renamed from: fm  reason: default package */
/* compiled from: Migration */
public abstract class fm {
    public final int endVersion;
    public final int startVersion;

    public fm(int i, int i2) {
        this.startVersion = i;
        this.endVersion = i2;
    }

    public abstract void migrate(om omVar);
}
