package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/* renamed from: lg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class lg3 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<og3, List<Throwable>> f2213a = new ConcurrentHashMap<>(16, 0.75f, 10);
    public final ReferenceQueue<Throwable> b = new ReferenceQueue<>();
}
