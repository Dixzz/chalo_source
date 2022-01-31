package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import defpackage.a32;
import defpackage.w72;
import defpackage.x22.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: x22  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class x22<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    public final a<?, O> f3873a;
    public final g<?> b;
    public final String c;

    /* renamed from: x22$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static abstract class a<T extends f, O> extends e<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T buildClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull x72 x72, @RecentlyNonNull O o, @RecentlyNonNull a32.b bVar, @RecentlyNonNull a32.c cVar) {
            return buildClient(context, looper, x72, (Object) o, (n32) bVar, (w32) cVar);
        }

        @RecentlyNonNull
        public T buildClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull x72 x72, @RecentlyNonNull O o, @RecentlyNonNull n32 n32, @RecentlyNonNull w32 w32) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* renamed from: x22$b */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface b {
    }

    /* renamed from: x22$c */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static class c<C extends b> {
    }

    /* renamed from: x22$d */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface d {

        /* renamed from: x22$d$a */
        /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
        public interface a extends d {
            @RecentlyNonNull
            Account x0();
        }

        /* renamed from: x22$d$b */
        /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
        public interface b extends d {
            @RecentlyNullable
            GoogleSignInAccount o0();
        }

        /* renamed from: x22$d$c */
        /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
        public static final class c implements d {
        }
    }

    /* renamed from: x22$e */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static abstract class e<T extends b, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        @RecentlyNonNull
        public List<Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: x22$f */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface f extends b {
        void connect(@RecentlyNonNull w72.c cVar);

        void disconnect();

        void disconnect(@RecentlyNonNull String str);

        void dump(@RecentlyNonNull String str, FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, String[] strArr);

        @RecentlyNonNull
        Feature[] getAvailableFeatures();

        @RecentlyNonNull
        String getEndpointPackageName();

        @RecentlyNullable
        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(c82 c82, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        @RecentlyNonNull
        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(@RecentlyNonNull w72.e eVar);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* renamed from: x22$g */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: x22$a<C extends x22$f, O extends x22$d> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: x22$g<C extends x22$f> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> x22(@RecentlyNonNull String str, @RecentlyNonNull a<C, O> aVar, @RecentlyNonNull g<C> gVar) {
        gj1.l(aVar, "Cannot construct an Api with a null ClientBuilder");
        gj1.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.f3873a = aVar;
        this.b = gVar;
    }
}
