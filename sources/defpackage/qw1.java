package defpackage;

import defpackage.iy1;
import defpackage.wv1;
import java.util.Objects;

/* renamed from: qw1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qw1 implements iy1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ax1 f2998a;
    public final /* synthetic */ wv1 b;
    public final /* synthetic */ Iterable c;
    public final /* synthetic */ jv1 d;
    public final /* synthetic */ int e;

    public /* synthetic */ qw1(ax1 ax1, wv1 wv1, Iterable iterable, jv1 jv1, int i) {
        this.f2998a = ax1;
        this.b = wv1;
        this.c = iterable;
        this.d = jv1;
        this.e = i;
    }

    @Override // defpackage.iy1.a
    public final Object execute() {
        ax1 ax1 = this.f2998a;
        wv1 wv1 = this.b;
        Iterable<cy1> iterable = this.c;
        jv1 jv1 = this.d;
        int i = this.e;
        Objects.requireNonNull(ax1);
        if (wv1.c() == wv1.a.TRANSIENT_ERROR) {
            ax1.c.c1(iterable);
            ax1.d.a(jv1, i + 1);
            return null;
        }
        ax1.c.u(iterable);
        if (wv1.c() == wv1.a.OK) {
            ax1.c.Q(jv1, wv1.b() + ax1.g.a());
        }
        if (!ax1.c.Y0(jv1)) {
            return null;
        }
        ax1.d.b(jv1, 1, true);
        return null;
    }
}
