package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: pw5  reason: default package */
/* compiled from: CompoundSubscription */
public class pw5 extends nx5 {
    public final List<nx5> c = new ArrayList();

    @Override // defpackage.nx5
    public synchronized void a() {
        Iterator it = new ArrayList(this.c).iterator();
        while (it.hasNext()) {
            nx5 nx5 = (nx5) it.next();
            nx5.a();
            this.c.remove(nx5);
        }
        super.a();
    }

    public synchronized void c(nx5 nx5) {
        if (!nx5.b()) {
            if (b()) {
                nx5.a();
            } else {
                this.c.add(nx5);
            }
        }
    }
}
