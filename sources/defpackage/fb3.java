package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/* renamed from: fb3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class fb3 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<eb3, List<Throwable>> f1109a = new ConcurrentHashMap<>(16, 0.75f, 10);
    public final ReferenceQueue<Throwable> b = new ReferenceQueue<>();
}
