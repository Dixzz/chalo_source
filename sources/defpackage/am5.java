package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: am5  reason: default package */
/* compiled from: ForwardingApplicationListener */
public class am5 implements xl5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<xl5> f180a = new ArrayList();

    @Override // defpackage.xl5
    public void a(long j) {
        Iterator it = new ArrayList(this.f180a).iterator();
        while (it.hasNext()) {
            ((xl5) it.next()).a(j);
        }
    }

    @Override // defpackage.xl5
    public void b(long j) {
        Iterator it = new ArrayList(this.f180a).iterator();
        while (it.hasNext()) {
            ((xl5) it.next()).b(j);
        }
    }
}
