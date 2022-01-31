package defpackage;

/* renamed from: i10  reason: default package */
/* compiled from: EtaObject */
public class i10 {

    /* renamed from: a  reason: collision with root package name */
    public int f1460a;
    public final long b;
    public long c;
    public final a d;
    public int e;
    public int f;
    public String g;
    public boolean h;

    /* renamed from: i10$a */
    /* compiled from: EtaObject */
    public enum a {
        FIXED,
        ESTIMATED
    }

    public i10(int i, long j) {
        this.d = a.FIXED;
        this.f1460a = i;
        this.b = j;
    }

    public i10(int i, int i2, long j, String str, long j2, boolean z) {
        this.d = a.ESTIMATED;
        this.f = i2;
        this.e = i;
        this.b = j;
        this.g = str;
        this.c = j2;
        this.h = z;
    }

    public i10(int i, long j, String str, long j2, boolean z) {
        this.d = a.FIXED;
        this.f1460a = i;
        this.b = j;
        this.g = str;
        this.c = j2;
        this.h = z;
    }
}
