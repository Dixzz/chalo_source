package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;

/* renamed from: sx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class sx2 extends px2 {

    /* renamed from: a  reason: collision with root package name */
    public final rx2 f3276a = new rx2();

    @Override // defpackage.px2
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            rx2 rx2 = this.f3276a;
            ReferenceQueue<Throwable> referenceQueue = rx2.b;
            while (true) {
                Reference<? extends Throwable> poll = referenceQueue.poll();
                if (poll == null) {
                    break;
                }
                rx2.f3145a.remove(poll);
                referenceQueue = rx2.b;
            }
            List list = (List) rx2.f3145a.get(new qx2(th, null));
            if (list == null) {
                list = new Vector(2);
                List list2 = (List) rx2.f3145a.putIfAbsent(new qx2(th, rx2.b), list);
                if (list2 != null) {
                    list = list2;
                }
            }
            list.add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
