package androidx.work;

import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    public UUID f261a;
    public np b;
    public Executor c;
    public dq d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f262a = Collections.emptyList();
        public List<Uri> b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, np npVar, Collection<String> collection, a aVar, int i, Executor executor, pt ptVar, dq dqVar, xp xpVar, jt jtVar) {
        this.f261a = uuid;
        this.b = npVar;
        new HashSet(collection);
        this.c = executor;
        this.d = dqVar;
    }
}
