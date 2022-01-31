package defpackage;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/* renamed from: gt3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class gt3 extends ct3 {

    /* renamed from: a  reason: collision with root package name */
    public final ft3 f1300a = new ft3();

    @Override // defpackage.ct3
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            ft3 ft3 = this.f1300a;
            for (Reference<? extends Throwable> poll = ft3.b.poll(); poll != null; poll = ft3.b.poll()) {
                ft3.f1170a.remove(poll);
            }
            List list = (List) ft3.f1170a.get(new et3(th, null));
            if (list == null) {
                list = new Vector(2);
                List list2 = (List) ft3.f1170a.putIfAbsent(new et3(th, ft3.b), list);
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
