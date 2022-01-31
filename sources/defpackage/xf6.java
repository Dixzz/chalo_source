package defpackage;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* renamed from: xf6  reason: default package */
/* compiled from: MainDispatchers.kt */
public final class xf6 {

    /* renamed from: a  reason: collision with root package name */
    public static final xf6 f3924a = new xf6();
    public static final boolean b;
    public static final ad6 c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    static {
        MainDispatcherFactory mainDispatcherFactory;
        String E = ec6.E("kotlinx.coroutines.fast.service.loader");
        b = E == null ? true : Boolean.parseBoolean(E);
        List<? extends MainDispatcherFactory> b3 = hd3.b3(hd3.s(a.b()));
        Iterator it = b3.iterator();
        if (!it.hasNext()) {
            mainDispatcherFactory = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            mainDispatcherFactory = next;
        }
        MainDispatcherFactory mainDispatcherFactory2 = mainDispatcherFactory;
        if (mainDispatcherFactory2 != null) {
            try {
                c = mainDispatcherFactory2.createDispatcher(b3);
            } catch (Throwable th) {
                mainDispatcherFactory2.hintOnError();
                throw th;
            }
        } else {
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        }
    }
}
