package defpackage;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzi;
import com.razorpay.AnalyticsConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: w72  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class w72<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @RecentlyNonNull
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @RecentlyNonNull
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @RecentlyNonNull
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zze = new Feature[0];
    private volatile String zzA;
    private ConnectionResult zzB;
    private boolean zzC;
    private volatile zzi zzD;
    public ra2 zza;
    public final Handler zzb;
    @RecentlyNonNull
    public c zzc;
    @RecentlyNonNull
    public AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final a82 zzn;
    private final r22 zzo;
    private final Object zzp;
    private final Object zzq;
    @GuardedBy("mServiceBrokerLock")
    private e82 zzr;
    @GuardedBy("mLock")
    private T zzs;
    private final ArrayList<ea2<?>> zzt;
    @GuardedBy("mLock")
    private ga2 zzu;
    @GuardedBy("mLock")
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;

    /* renamed from: w72$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface a {
        void C(int i);

        void L(Bundle bundle);
    }

    /* renamed from: w72$b */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface b {
        void F(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* renamed from: w72$c */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface c {
        void a(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* renamed from: w72$d */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public class d implements c {
        public d() {
        }

        @Override // defpackage.w72.c
        public final void a(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.m1()) {
                w72 w72 = w72.this;
                w72.getRemoteService(null, w72.getScopes());
            } else if (w72.this.zzx != null) {
                w72.this.zzx.F(connectionResult);
            }
        }
    }

    /* renamed from: w72$e */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface e {
    }

    public w72(@RecentlyNonNull Context context, @RecentlyNonNull Handler handler, @RecentlyNonNull a82 a82, @RecentlyNonNull r22 r22, int i, a aVar, b bVar) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        gj1.l(context, "Context must not be null");
        this.zzl = context;
        gj1.l(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        gj1.l(a82, "Supervisor must not be null");
        this.zzn = a82;
        gj1.l(r22, "API availability must not be null");
        this.zzo = r22;
        this.zzy = i;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = null;
    }

    public static /* synthetic */ void zzc(w72 w72, int i) {
        int i2;
        int i3;
        synchronized (w72.zzp) {
            i2 = w72.zzv;
        }
        if (i2 == 3) {
            w72.zzC = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = w72.zzb;
        handler.sendMessage(handler.obtainMessage(i3, w72.zzd.get(), 16));
    }

    public static /* synthetic */ boolean zzg(w72 w72) {
        if (w72.zzC || TextUtils.isEmpty(w72.getServiceDescriptor()) || TextUtils.isEmpty(w72.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(w72.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean zzl(w72 w72, int i, int i2, IInterface iInterface) {
        synchronized (w72.zzp) {
            if (w72.zzv != i) {
                return false;
            }
            w72.zzp(i2, iInterface);
            return true;
        }
    }

    public static void zzo(w72 w72, zzi zzi2) {
        w72.zzD = zzi2;
        if (w72.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzi2.i;
            i82 a2 = i82.a();
            RootTelemetryConfiguration rootTelemetryConfiguration = connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.f;
            synchronized (a2) {
                if (rootTelemetryConfiguration == null) {
                    a2.f1489a = i82.c;
                    return;
                }
                RootTelemetryConfiguration rootTelemetryConfiguration2 = a2.f1489a;
                if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.f < rootTelemetryConfiguration.f) {
                    a2.f1489a = rootTelemetryConfiguration;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzp(int i, T t) {
        ra2 ra2;
        String str;
        ra2 ra22;
        gj1.b((i == 4) == (t != null));
        synchronized (this.zzp) {
            this.zzv = i;
            this.zzs = t;
            if (i == 1) {
                ga2 ga2 = this.zzu;
                if (ga2 != null) {
                    a82 a82 = this.zzn;
                    String str2 = this.zza.f3064a;
                    Objects.requireNonNull(str2, "null reference");
                    a82.b(str2, this.zza.b, 4225, ga2, zza(), this.zza.c);
                    this.zzu = null;
                }
            } else if (i == 2 || i == 3) {
                ga2 ga22 = this.zzu;
                if (!(ga22 == null || (ra22 = this.zza) == null)) {
                    String str3 = ra22.f3064a;
                    String str4 = ra22.b;
                    String.valueOf(str3).length();
                    String.valueOf(str4).length();
                    a82 a822 = this.zzn;
                    String str5 = this.zza.f3064a;
                    Objects.requireNonNull(str5, "null reference");
                    a822.b(str5, this.zza.b, 4225, ga22, zza(), this.zza.c);
                    this.zzd.incrementAndGet();
                }
                ga2 ga23 = new ga2(this, this.zzd.get());
                this.zzu = ga23;
                if (this.zzv != 3 || getLocalStartServiceAction() == null) {
                    String startServicePackage = getStartServicePackage();
                    String startServiceAction = getStartServiceAction();
                    Object obj = a82.f133a;
                    ra2 = new ra2(startServicePackage, startServiceAction, 4225, getUseDynamicLookup());
                } else {
                    String packageName = getContext().getPackageName();
                    String localStartServiceAction = getLocalStartServiceAction();
                    Object obj2 = a82.f133a;
                    ra2 = new ra2(packageName, localStartServiceAction, 4225, false);
                }
                this.zza = ra2;
                if (!ra2.c || getMinApkVersion() >= 17895000) {
                    a82 a823 = this.zzn;
                    String str6 = this.zza.f3064a;
                    Objects.requireNonNull(str6, "null reference");
                    if (!a823.c(new ma2(str6, this.zza.b, 4225, this.zza.c), ga23, zza())) {
                        ra2 ra23 = this.zza;
                        String str7 = ra23.f3064a;
                        String str8 = ra23.b;
                        String.valueOf(str7).length();
                        String.valueOf(str8).length();
                        zzb(16, null, this.zzd.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.zza.f3064a);
                    if (valueOf.length() != 0) {
                        str = "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf);
                    } else {
                        str = new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ");
                    }
                    throw new IllegalStateException(str);
                }
            } else if (i == 4) {
                Objects.requireNonNull(t, "null reference");
                onConnectedLocked(t);
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int c2 = this.zzo.c(this.zzl, getMinApkVersion());
        if (c2 != 0) {
            zzp(1, null);
            triggerNotAvailable(new d(), c2, null);
            return;
        }
        connect(new d());
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(@RecentlyNonNull c cVar) {
        gj1.l(cVar, "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        zzp(2, null);
    }

    @RecentlyNullable
    public abstract T createServiceInterface(@RecentlyNonNull IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i = 0; i < size; i++) {
                ea2<?> ea2 = this.zzt.get(i);
                synchronized (ea2) {
                    ea2.f948a = null;
                }
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    public void dump(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr) {
        int i;
        T t;
        e82 e82;
        synchronized (this.zzp) {
            i = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            e82 = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append(AnalyticsConstants.NULL);
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (e82 == null) {
            printWriter.println(AnalyticsConstants.NULL);
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(e82.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzh;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zzf;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzg;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) gj1.K(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzj;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    @RecentlyNullable
    public Account getAccount() {
        return null;
    }

    @RecentlyNonNull
    public Feature[] getApiFeatures() {
        return zze;
    }

    @RecentlyNullable
    public final Feature[] getAvailableFeatures() {
        zzi zzi2 = this.zzD;
        if (zzi2 == null) {
            return null;
        }
        return zzi2.g;
    }

    @RecentlyNullable
    public Bundle getConnectionHint() {
        return null;
    }

    @RecentlyNonNull
    public final Context getContext() {
        return this.zzl;
    }

    @RecentlyNonNull
    public String getEndpointPackageName() {
        ra2 ra2;
        if (isConnected() && (ra2 = this.zza) != null) {
            return ra2.b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    @RecentlyNonNull
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @RecentlyNullable
    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    @RecentlyNullable
    public String getLocalStartServiceAction() {
        return null;
    }

    @RecentlyNonNull
    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return r22.f3028a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        onPostInitHandler(8, null, null, r4.zzd.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getRemoteService(defpackage.c82 r5, @androidx.annotation.RecentlyNonNull java.util.Set<com.google.android.gms.common.api.Scope> r6) {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w72.getRemoteService(c82, java.util.Set):void");
    }

    @RecentlyNonNull
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @RecentlyNonNull
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                t = this.zzs;
                gj1.l(t, "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @RecentlyNullable
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            e82 e82 = this.zzr;
            if (e82 == null) {
                return null;
            }
            return e82.asBinder();
        }
    }

    public abstract String getServiceDescriptor();

    @RecentlyNonNull
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    @RecentlyNonNull
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @RecentlyNullable
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzi zzi2 = this.zzD;
        if (zzi2 == null) {
            return null;
        }
        return zzi2.i;
    }

    public boolean getUseDynamicLookup() {
        return false;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2) {
                if (i != 3) {
                    z = false;
                }
            }
        }
        return z;
    }

    public void onConnectedLocked(@RecentlyNonNull T t) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult) {
        this.zzi = connectionResult.g;
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new ha2(this, i, iBinder, bundle)));
    }

    public void onUserSignOut(@RecentlyNonNull e eVar) {
        o52 o52 = (o52) eVar;
        o52.f2652a.r.n.post(new n52(o52));
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(@RecentlyNonNull String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), i));
    }

    public void triggerNotAvailable(@RecentlyNonNull c cVar, int i, PendingIntent pendingIntent) {
        gj1.l(cVar, "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), i, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    @RecentlyNonNull
    public final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzb(int i, Bundle bundle, int i2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new ia2(this, i)));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w72(@androidx.annotation.RecentlyNonNull android.content.Context r10, @androidx.annotation.RecentlyNonNull android.os.Looper r11, int r12, defpackage.w72.a r13, defpackage.w72.b r14, java.lang.String r15) {
        /*
            r9 = this;
            a82 r3 = defpackage.a82.a(r10)
            r22 r4 = defpackage.r22.b
            java.lang.String r0 = "null reference"
            java.util.Objects.requireNonNull(r13, r0)
            java.util.Objects.requireNonNull(r14, r0)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w72.<init>(android.content.Context, android.os.Looper, int, w72$a, w72$b, java.lang.String):void");
    }

    public w72(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull a82 a82, @RecentlyNonNull r22 r22, int i, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        gj1.l(context, "Context must not be null");
        this.zzl = context;
        gj1.l(looper, "Looper must not be null");
        this.zzm = looper;
        gj1.l(a82, "Supervisor must not be null");
        this.zzn = a82;
        gj1.l(r22, "API availability must not be null");
        this.zzo = r22;
        this.zzb = new da2(this, looper);
        this.zzy = i;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    public void disconnect(@RecentlyNonNull String str) {
        this.zzk = str;
        disconnect();
    }
}
