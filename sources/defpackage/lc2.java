package defpackage;

import java.util.Iterator;

/* renamed from: lc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class lc2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ hc2 f2199a;

    public lc2(hc2 hc2) {
        this.f2199a = hc2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: jc2 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(jc2 jc2) {
        hc2 hc2 = this.f2199a;
        hc2.f1357a = jc2;
        Iterator<sc2> it = hc2.c.iterator();
        while (it.hasNext()) {
            it.next().a(this.f2199a.f1357a);
        }
        this.f2199a.c.clear();
        this.f2199a.b = null;
    }
}
