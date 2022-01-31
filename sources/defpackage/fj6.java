package defpackage;

/* renamed from: fj6  reason: default package */
/* compiled from: Task.kt */
public abstract class fj6 {

    /* renamed from: a  reason: collision with root package name */
    public hj6 f1131a;
    public long b;
    public final String c;
    public final boolean d;

    public fj6(String str, boolean z) {
        n86.f(str, "name");
        this.c = str;
        this.d = z;
        this.b = -1;
    }

    public abstract long a();

    public String toString() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fj6(String str, boolean z, int i) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
