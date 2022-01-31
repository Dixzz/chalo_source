package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/* renamed from: rx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class rx2 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<qx2, List<Throwable>> f3145a = new ConcurrentHashMap<>(16, 0.75f, 10);
    public final ReferenceQueue<Throwable> b = new ReferenceQueue<>();
}
