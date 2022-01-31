package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.util.List;

/* renamed from: ft3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ft3 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<et3, List<Throwable>> f1170a = new ConcurrentHashMap<>(16, 0.75f, 10);
    public final ReferenceQueue<Throwable> b = new ReferenceQueue<>();
}
