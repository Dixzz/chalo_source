package defpackage;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import defpackage.x22;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* renamed from: a32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class a32 {
    @GuardedBy("sAllClients")

    /* renamed from: a  reason: collision with root package name */
    public static final Set<a32> f103a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    /* renamed from: a32$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f104a = new HashSet();
        public final Set<Scope> b = new HashSet();
        public String c;
        public String d;
        public final Map<x22<?>, c92> e = new n2();
        public final Context f;
        public final Map<x22<?>, x22.d> g = new n2();
        public r32 h;
        public int i = -1;
        public c j;
        public Looper k;
        public q22 l;
        public x22.a<? extends ni4, zh4> m;
        public final ArrayList<b> n;
        public final ArrayList<c> o;

        public a(@RecentlyNonNull Context context) {
            Object obj = q22.c;
            this.l = q22.d;
            this.m = mi4.c;
            this.n = new ArrayList<>();
            this.o = new ArrayList<>();
            this.f = context;
            this.k = context.getMainLooper();
            this.c = context.getPackageName();
            this.d = context.getClass().getName();
        }

        @RecentlyNonNull
        public a a(@RecentlyNonNull x22<? extends Object> x22) {
            gj1.l(x22, "Api must not be null");
            this.g.put(x22, null);
            x22.a<?, O> aVar = x22.f3873a;
            gj1.l(aVar, "Base client builder must not be null");
            List<Scope> impliedScopes = aVar.getImpliedScopes(null);
            this.b.addAll(impliedScopes);
            this.f104a.addAll(impliedScopes);
            return this;
        }

        @RecentlyNonNull
        public a b(@RecentlyNonNull b bVar) {
            gj1.l(bVar, "Listener must not be null");
            this.n.add(bVar);
            return this;
        }

        @RecentlyNonNull
        public a c(@RecentlyNonNull c cVar) {
            gj1.l(cVar, "Listener must not be null");
            this.o.add(cVar);
            return this;
        }

        @RecentlyNonNull
        public a32 d() {
            gj1.c(!this.g.isEmpty(), "must call addApi() to add at least one API");
            zh4 zh4 = zh4.f;
            Map<x22<?>, x22.d> map = this.g;
            x22<zh4> x22 = mi4.e;
            if (map.containsKey(x22)) {
                zh4 = (zh4) this.g.get(x22);
            }
            x72 x72 = new x72(null, this.f104a, this.e, 0, null, this.c, this.d, zh4);
            Map<x22<?>, c92> map2 = x72.d;
            n2 n2Var = new n2();
            n2 n2Var2 = new n2();
            ArrayList arrayList = new ArrayList();
            x22<?> x222 = null;
            boolean z = false;
            for (x22<?> x223 : this.g.keySet()) {
                x22.d dVar = this.g.get(x223);
                boolean z2 = map2.get(x223) != null;
                n2Var.put(x223, Boolean.valueOf(z2));
                a72 a72 = new a72(x223, z2);
                arrayList.add(a72);
                x22.a<?, O> aVar = x223.f3873a;
                Objects.requireNonNull(aVar, "null reference");
                x22.f buildClient = aVar.buildClient(this.f, this.k, x72, (O) dVar, (b) a72, (c) a72);
                n2Var2.put(x223.b, buildClient);
                if (aVar.getPriority() == 1) {
                    z = dVar != null;
                }
                if (buildClient.providesSignIn()) {
                    if (x222 == null) {
                        x222 = x223;
                    } else {
                        String str = x223.c;
                        String str2 = x222.c;
                        throw new IllegalStateException(hj1.b0(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length()), str, " cannot be used with ", str2));
                    }
                }
            }
            if (x222 != null) {
                if (!z) {
                    boolean equals = this.f104a.equals(this.b);
                    Object[] objArr = {x222.c};
                    if (!equals) {
                        throw new IllegalStateException(String.format("Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", objArr));
                    }
                } else {
                    String str3 = x222.c;
                    throw new IllegalStateException(hj1.b0(new StringBuilder(String.valueOf(str3).length() + 82), "With using ", str3, ", GamesOptions can only be specified within GoogleSignInOptions.Builder"));
                }
            }
            boolean z3 = true;
            d52 d52 = new d52(this.f, new ReentrantLock(), this.k, x72, this.l, this.m, n2Var, this.n, this.o, n2Var2, this.i, d52.v(n2Var2.values(), true), arrayList);
            Set<a32> set = a32.f103a;
            synchronized (set) {
                set.add(d52);
            }
            if (this.i >= 0) {
                s32 c2 = LifecycleCallback.c(this.h);
                s62 s62 = (s62) c2.b("AutoManageHelper", s62.class);
                if (s62 == null) {
                    s62 = new s62(c2);
                }
                int i2 = this.i;
                c cVar = this.j;
                gj1.l(d52, "GoogleApiClient instance cannot be null");
                if (s62.k.indexOfKey(i2) >= 0) {
                    z3 = false;
                }
                StringBuilder sb = new StringBuilder(54);
                sb.append("Already managing a GoogleApiClient with id ");
                sb.append(i2);
                gj1.o(z3, sb.toString());
                u62 u62 = s62.h.get();
                String.valueOf(u62).length();
                r62 r62 = new r62(s62, i2, d52, cVar);
                d52.c.c(r62);
                s62.k.put(i2, r62);
                if (s62.g && u62 == null) {
                    String.valueOf(d52).length();
                    d52.f();
                }
            }
            return d52;
        }
    }

    @Deprecated
    /* renamed from: a32$b */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface b extends n32 {
    }

    @Deprecated
    /* renamed from: a32$c */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface c extends w32 {
    }

    @RecentlyNonNull
    public abstract ConnectionResult d();

    @RecentlyNonNull
    public abstract b32<Status> e();

    public abstract void f();

    public abstract void g();

    public abstract void h(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr);

    @RecentlyNonNull
    public <A extends x22.b, R extends f32, T extends l32<R, A>> T i(@RecentlyNonNull T t) {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    public <A extends x22.b, T extends l32<? extends f32, A>> T j(@RecentlyNonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <C extends x22.f> C k(@RecentlyNonNull x22.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    public Context l() {
        throw new UnsupportedOperationException();
    }

    @RecentlyNonNull
    public Looper m() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean n();

    public boolean o(@RecentlyNonNull a42 a42) {
        throw new UnsupportedOperationException();
    }

    public void p() {
        throw new UnsupportedOperationException();
    }

    public abstract void q(@RecentlyNonNull b bVar);

    public abstract void r(@RecentlyNonNull c cVar);

    public abstract void s(@RecentlyNonNull b bVar);

    public abstract void t(@RecentlyNonNull c cVar);
}
