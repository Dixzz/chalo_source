package defpackage;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* renamed from: gw4  reason: default package */
public final class gw4 extends dw4 {

    /* renamed from: a  reason: collision with root package name */
    public final fw4 f1309a = new fw4();

    @Override // defpackage.dw4
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            fw4 fw4 = this.f1309a;
            while (true) {
                Reference<? extends Throwable> poll = fw4.b.poll();
                if (poll == null) {
                    break;
                }
                fw4.f1178a.remove(poll);
            }
            List list = (List) fw4.f1178a.get(new ew4(th, null));
            if (list == null) {
                list = new Vector(2);
                List list2 = (List) fw4.f1178a.putIfAbsent(new ew4(th, fw4.b), list);
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
