package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;

/* renamed from: gb3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class gb3 extends db3 {

    /* renamed from: a  reason: collision with root package name */
    public final fb3 f1235a = new fb3();

    @Override // defpackage.db3
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            fb3 fb3 = this.f1235a;
            ReferenceQueue<Throwable> referenceQueue = fb3.b;
            while (true) {
                Reference<? extends Throwable> poll = referenceQueue.poll();
                if (poll == null) {
                    break;
                }
                fb3.f1109a.remove(poll);
                referenceQueue = fb3.b;
            }
            List list = (List) fb3.f1109a.get(new eb3(th, null));
            if (list == null) {
                list = new Vector(2);
                List list2 = (List) fb3.f1109a.putIfAbsent(new eb3(th, fb3.b), list);
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
