package defpackage;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* renamed from: ng3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ng3 extends mg3 {

    /* renamed from: a  reason: collision with root package name */
    public final lg3 f2551a = new lg3();

    @Override // defpackage.mg3
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            lg3 lg3 = this.f2551a;
            for (Reference<? extends Throwable> poll = lg3.b.poll(); poll != null; poll = lg3.b.poll()) {
                lg3.f2213a.remove(poll);
            }
            List list = (List) lg3.f2213a.get(new og3(th, null));
            if (list == null) {
                list = new Vector(2);
                List list2 = (List) lg3.f2213a.putIfAbsent(new og3(th, lg3.b), list);
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
