package defpackage;

import android.os.Build;
import androidx.work.ListenableWorker;
import defpackage.vp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* renamed from: bq  reason: default package */
/* compiled from: WorkRequest */
public abstract class bq {

    /* renamed from: a  reason: collision with root package name */
    public UUID f466a;
    public rs b;
    public Set<String> c;

    /* renamed from: bq$a */
    /* compiled from: WorkRequest */
    public static abstract class a<B extends a<?, ?>, W extends bq> {

        /* renamed from: a  reason: collision with root package name */
        public UUID f467a = UUID.randomUUID();
        public rs b;
        public Set<String> c = new HashSet();

        public a(Class<? extends ListenableWorker> cls) {
            this.b = new rs(this.f467a.toString(), cls.getName());
            this.c.add(cls.getName());
        }

        public final W a() {
            vp.a aVar = (vp.a) this;
            rs rsVar = aVar.b;
            if (!rsVar.q || Build.VERSION.SDK_INT < 23 || !rsVar.j.c) {
                vp vpVar = new vp(aVar);
                this.f467a = UUID.randomUUID();
                rs rsVar2 = new rs(this.b);
                this.b = rsVar2;
                rsVar2.f3122a = this.f467a.toString();
                return vpVar;
            }
            throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
        }
    }

    public bq(UUID uuid, rs rsVar, Set<String> set) {
        this.f466a = uuid;
        this.b = rsVar;
        this.c = set;
    }

    public String a() {
        return this.f466a.toString();
    }
}
