package defpackage;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: l  reason: default package */
/* compiled from: OnBackPressedCallback */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2142a;
    public CopyOnWriteArrayList<k> b = new CopyOnWriteArrayList<>();

    public l(boolean z) {
        this.f2142a = z;
    }

    public abstract void a();

    public final void b() {
        Iterator<k> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }
}
