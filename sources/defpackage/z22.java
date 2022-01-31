package defpackage;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import defpackage.a32;
import defpackage.t32;
import defpackage.x22;
import defpackage.x22.d;
import defpackage.x72;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: z22  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class z22<O extends x22.d> {
    @RecentlyNonNull
    public final o32 zaa;
    private final Context zab;
    private final String zac;
    private final x22<O> zad;
    private final O zae;
    private final j32<O> zaf;
    private final Looper zag;
    private final int zah;
    @NotOnlyInitialized
    private final a32 zai;
    private final b42 zaj;

    /* renamed from: z22$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static class a {
        @RecentlyNonNull
        public static final a c = new a(new i32(), null, Looper.getMainLooper());
        @RecentlyNonNull

        /* renamed from: a  reason: collision with root package name */
        public final b42 f4110a;
        @RecentlyNonNull
        public final Looper b;

        public a(b42 b42, Account account, Looper looper) {
            this.f4110a = b42;
            this.b = looper;
        }
    }

    public z22(@RecentlyNonNull Activity activity, @RecentlyNonNull x22<O> x22, @RecentlyNonNull O o, @RecentlyNonNull a aVar) {
        gj1.l(activity, "Null activity is not permitted.");
        gj1.l(x22, "Api must not be null.");
        gj1.l(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.zab = applicationContext;
        String zaf2 = zaf(activity);
        this.zac = zaf2;
        this.zad = x22;
        this.zae = o;
        this.zag = aVar.b;
        j32<O> j32 = new j32<>(x22, o, zaf2);
        this.zaf = j32;
        this.zai = new t52(this);
        o32 e = o32.e(applicationContext);
        this.zaa = e;
        this.zah = e.h.getAndIncrement();
        this.zaj = aVar.f4110a;
        if (!(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            s32 c = LifecycleCallback.c(new r32(activity));
            g42 g42 = (g42) c.b("ConnectionlessLifecycleHelper", g42.class);
            if (g42 == null) {
                Object obj = q22.c;
                g42 = new g42(c, e, q22.d);
            }
            gj1.l(j32, "ApiKey cannot be null");
            g42.k.add(j32);
            e.f(g42);
        }
        Handler handler = e.n;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    private final <A extends x22.b, T extends l32<? extends f32, A>> T zad(int i, T t) {
        t.j();
        o32 o32 = this.zaa;
        Objects.requireNonNull(o32);
        n62 n62 = new n62(i, t);
        Handler handler = o32.n;
        handler.sendMessage(handler.obtainMessage(4, new d62(n62, o32.i.get(), this)));
        return t;
    }

    private final <TResult, A extends x22.b> yi4<TResult> zae(int i, d42<A, TResult> d42) {
        zi4 zi4 = new zi4();
        o32 o32 = this.zaa;
        b42 b42 = this.zaj;
        Objects.requireNonNull(o32);
        o32.b(zi4, d42.zab(), this);
        o62 o62 = new o62(i, d42, zi4, b42);
        Handler handler = o32.n;
        handler.sendMessage(handler.obtainMessage(4, new d62(o62, o32.i.get(), this)));
        return zi4.f4178a;
    }

    private static String zaf(Object obj) {
        if (!(Build.VERSION.SDK_INT >= 30)) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @RecentlyNonNull
    public a32 asGoogleApiClient() {
        return this.zai;
    }

    @RecentlyNonNull
    public x72.a createClientSettingsBuilder() {
        Set<Scope> set;
        GoogleSignInAccount o0;
        x72.a aVar = new x72.a();
        O o = this.zae;
        Account account = null;
        if (!(o instanceof x22.d.b) || (o0 = ((x22.d.b) o).o0()) == null) {
            O o2 = this.zae;
            if (o2 instanceof x22.d.a) {
                account = ((x22.d.a) o2).x0();
            }
        } else {
            String str = o0.i;
            if (str != null) {
                account = new Account(str, "com.google");
            }
        }
        aVar.f3897a = account;
        O o3 = this.zae;
        if (o3 instanceof x22.d.b) {
            GoogleSignInAccount o02 = ((x22.d.b) o3).o0();
            if (o02 == null) {
                set = Collections.emptySet();
            } else {
                set = o02.l1();
            }
        } else {
            set = Collections.emptySet();
        }
        if (aVar.b == null) {
            aVar.b = new p2<>(0);
        }
        aVar.b.addAll(set);
        aVar.d = this.zab.getClass().getName();
        aVar.c = this.zab.getPackageName();
        return aVar;
    }

    @RecentlyNonNull
    public yi4<Boolean> disconnectService() {
        o32 o32 = this.zaa;
        Objects.requireNonNull(o32);
        h42 h42 = new h42(getApiKey());
        Handler handler = o32.n;
        handler.sendMessage(handler.obtainMessage(14, h42));
        return h42.b.f4178a;
    }

    @RecentlyNonNull
    public <A extends x22.b, T extends l32<? extends f32, A>> T doBestEffortWrite(@RecentlyNonNull T t) {
        zad(2, t);
        return t;
    }

    @RecentlyNonNull
    public <A extends x22.b, T extends l32<? extends f32, A>> T doRead(@RecentlyNonNull T t) {
        zad(0, t);
        return t;
    }

    @RecentlyNonNull
    @Deprecated
    public <A extends x22.b, T extends x32<A, ?>, U extends e42<A, ?>> yi4<Void> doRegisterEventListener(@RecentlyNonNull T t, @RecentlyNonNull U u) {
        throw null;
    }

    @RecentlyNonNull
    public yi4<Boolean> doUnregisterEventListener(@RecentlyNonNull t32.a<?> aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    @RecentlyNonNull
    public <A extends x22.b, T extends l32<? extends f32, A>> T doWrite(@RecentlyNonNull T t) {
        zad(1, t);
        return t;
    }

    @RecentlyNonNull
    public final j32<O> getApiKey() {
        return this.zaf;
    }

    @RecentlyNonNull
    public O getApiOptions() {
        return this.zae;
    }

    @RecentlyNonNull
    public Context getApplicationContext() {
        return this.zab;
    }

    @RecentlyNullable
    public String getContextAttributionTag() {
        return this.zac;
    }

    @RecentlyNullable
    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    @RecentlyNonNull
    public Looper getLooper() {
        return this.zag;
    }

    @RecentlyNonNull
    public <L> t32<L> registerListener(@RecentlyNonNull L l, @RecentlyNonNull String str) {
        Looper looper = this.zag;
        gj1.l(l, "Listener must not be null");
        gj1.l(looper, "Looper must not be null");
        gj1.l(str, "Listener type must not be null");
        return new t32<>(looper, l, str);
    }

    public final x22.f zaa(Looper looper, p52<O> p52) {
        x72 a2 = createClientSettingsBuilder().a();
        x22.a<?, O> aVar = this.zad.f3873a;
        Objects.requireNonNull(aVar, "null reference");
        x22.f buildClient = aVar.buildClient(this.zab, looper, a2, this.zae, (a32.b) p52, (a32.c) p52);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof w72)) {
            ((w72) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof v32)) {
            Objects.requireNonNull((v32) buildClient);
        }
        return buildClient;
    }

    public final int zab() {
        return this.zah;
    }

    public final i62 zac(Context context, Handler handler) {
        return new i62(context, handler, createClientSettingsBuilder().a());
    }

    @RecentlyNonNull
    public <TResult, A extends x22.b> yi4<TResult> doBestEffortWrite(@RecentlyNonNull d42<A, TResult> d42) {
        return zae(2, d42);
    }

    @RecentlyNonNull
    public <TResult, A extends x22.b> yi4<TResult> doRead(@RecentlyNonNull d42<A, TResult> d42) {
        return zae(0, d42);
    }

    @RecentlyNonNull
    public <A extends x22.b> yi4<Void> doRegisterEventListener(@RecentlyNonNull y32<A, ?> y32) {
        throw null;
    }

    @RecentlyNonNull
    public yi4<Boolean> doUnregisterEventListener(@RecentlyNonNull t32.a<?> aVar, int i) {
        gj1.l(aVar, "Listener key cannot be null.");
        o32 o32 = this.zaa;
        Objects.requireNonNull(o32);
        zi4 zi4 = new zi4();
        o32.b(zi4, i, this);
        p62 p62 = new p62(aVar, zi4);
        Handler handler = o32.n;
        handler.sendMessage(handler.obtainMessage(13, new d62(p62, o32.i.get(), this)));
        return zi4.f4178a;
    }

    @RecentlyNonNull
    public <TResult, A extends x22.b> yi4<TResult> doWrite(@RecentlyNonNull d42<A, TResult> d42) {
        return zae(1, d42);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z22(@androidx.annotation.RecentlyNonNull android.app.Activity r4, @androidx.annotation.RecentlyNonNull defpackage.x22<O> r5, @androidx.annotation.RecentlyNonNull O r6, @androidx.annotation.RecentlyNonNull defpackage.b42 r7) {
        /*
            r3 = this;
            java.lang.String r0 = "StatusExceptionMapper must not be null."
            defpackage.gj1.l(r7, r0)
            android.os.Looper r0 = r4.getMainLooper()
            java.lang.String r1 = "Looper must not be null."
            defpackage.gj1.l(r0, r1)
            z22$a r1 = new z22$a
            r2 = 0
            r1.<init>(r7, r2, r0)
            r3.<init>(r4, r5, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z22.<init>(android.app.Activity, x22, x22$d, b42):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public z22(@RecentlyNonNull Context context, @RecentlyNonNull x22<O> x22, @RecentlyNonNull O o, @RecentlyNonNull Looper looper, @RecentlyNonNull b42 b42) {
        this(context, x22, o, new a(b42, null, looper));
        gj1.l(looper, "Looper must not be null.");
        gj1.l(b42, "StatusExceptionMapper must not be null.");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public z22(@RecentlyNonNull Context context, @RecentlyNonNull x22<O> x22, @RecentlyNonNull O o, @RecentlyNonNull b42 b42) {
        this(context, x22, o, new a(b42, null, Looper.getMainLooper()));
        gj1.l(b42, "StatusExceptionMapper must not be null.");
    }

    public z22(@RecentlyNonNull Context context, @RecentlyNonNull x22<O> x22, @RecentlyNonNull O o, @RecentlyNonNull a aVar) {
        gj1.l(context, "Null context is not permitted.");
        gj1.l(x22, "Api must not be null.");
        gj1.l(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.zab = applicationContext;
        String zaf2 = zaf(context);
        this.zac = zaf2;
        this.zad = x22;
        this.zae = o;
        this.zag = aVar.b;
        this.zaf = new j32<>(x22, o, zaf2);
        this.zai = new t52(this);
        o32 e = o32.e(applicationContext);
        this.zaa = e;
        this.zah = e.h.getAndIncrement();
        this.zaj = aVar.f4110a;
        Handler handler = e.n;
        handler.sendMessage(handler.obtainMessage(7, this));
    }
}
