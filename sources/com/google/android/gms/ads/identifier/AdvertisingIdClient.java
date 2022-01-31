package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import server.zophop.Constants;

@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    @GuardedBy("this")
    private final Context mContext;
    @GuardedBy("this")
    private o22 zze;
    @GuardedBy("this")
    private id2 zzf;
    @GuardedBy("this")
    private boolean zzg;
    private final Object zzh;
    @GuardedBy("mAutoDisconnectTaskLock")
    private a zzi;
    private final boolean zzj;
    private final long zzk;

    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String str = this.zzq;
            boolean z = this.zzr;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public static class a extends Thread {
        public WeakReference<AdvertisingIdClient> f;
        public long g;
        public CountDownLatch h = new CountDownLatch(1);
        public boolean i = false;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f = new WeakReference<>(advertisingIdClient);
            this.g = j;
            start();
        }

        public final void run() {
            AdvertisingIdClient advertisingIdClient;
            try {
                if (!this.h.await(this.g, TimeUnit.MILLISECONDS) && (advertisingIdClient = this.f.get()) != null) {
                    advertisingIdClient.finish();
                    this.i = true;
                }
            } catch (InterruptedException unused) {
                AdvertisingIdClient advertisingIdClient2 = this.f.get();
                if (advertisingIdClient2 != null) {
                    advertisingIdClient2.finish();
                    this.i = true;
                }
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    private AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.zzh = new Object();
        Objects.requireNonNull(context, "null reference");
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.mContext = context;
        this.zzg = false;
        this.zzk = j;
        this.zzj = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0020 A[SYNTHETIC, Splitter:B:15:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[SYNTHETIC, Splitter:B:22:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003a A[SYNTHETIC, Splitter:B:29:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getAdvertisingIdInfo(android.content.Context r13) throws java.io.IOException, java.lang.IllegalStateException, defpackage.s22, defpackage.t22 {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(android.content.Context):com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getIsAdIdFakeForDebugLogging(android.content.Context r9) throws java.io.IOException, defpackage.s22, defpackage.t22 {
        /*
            r0 = 0
            r1 = 0
            android.content.Context r2 = defpackage.u22.getRemoteContext(r9)     // Catch:{ all -> 0x000f }
            if (r2 != 0) goto L_0x0009
            goto L_0x000f
        L_0x0009:
            java.lang.String r3 = "google_ads_flags"
            android.content.SharedPreferences r0 = r2.getSharedPreferences(r3, r1)     // Catch:{ all -> 0x000f }
        L_0x000f:
            java.lang.String r2 = "gads:ad_id_app_context:enabled"
            if (r0 != 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            boolean r2 = r0.getBoolean(r2, r1)     // Catch:{ all -> 0x001a }
            r7 = r2
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            java.lang.String r2 = "com.google.android.gms.ads.identifier.service.PERSISTENT_START"
            if (r0 != 0) goto L_0x0020
            goto L_0x0026
        L_0x0020:
            boolean r0 = r0.getBoolean(r2, r1)     // Catch:{ all -> 0x0026 }
            r8 = r0
            goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            com.google.android.gms.ads.identifier.AdvertisingIdClient r0 = new com.google.android.gms.ads.identifier.AdvertisingIdClient
            r5 = -1
            r3 = r0
            r4 = r9
            r3.<init>(r4, r5, r7, r8)
            r0.zza(r1)     // Catch:{ all -> 0x003b }
            boolean r9 = r0.zzb()     // Catch:{ all -> 0x003b }
            r0.finish()
            return r9
        L_0x003b:
            r9 = move-exception
            r0.finish()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.getIsAdIdFakeForDebugLogging(android.content.Context):boolean");
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static o22 zza(Context context, boolean z) throws IOException, s22, t22 {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int c = r22.b.c(context, u22.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (c == 0 || c == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                o22 o22 = new o22();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (za2.b().a(context, intent, o22, 1)) {
                        return o22;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new s22(9);
        }
    }

    private final void zza() {
        synchronized (this.zzh) {
            a aVar = this.zzi;
            if (aVar != null) {
                aVar.h.countDown();
                try {
                    this.zzi.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzk > 0) {
                this.zzi = new a(this, this.zzk);
            }
        }
    }

    private final void zza(boolean z) throws IOException, IllegalStateException, s22, t22 {
        gj1.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                finish();
            }
            o22 zza = zza(this.mContext, this.zzj);
            this.zze = zza;
            this.zzf = zza(this.mContext, zza);
            this.zzg = true;
            if (z) {
                zza();
            }
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", z ? str2 : "0");
        if (info != null) {
            if (!info.isLimitAdTrackingEnabled()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new sy1(hashMap).start();
        return true;
    }

    private final boolean zzb() throws IOException {
        boolean zzc;
        gj1.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    a aVar = this.zzi;
                    if (aVar == null || !aVar.i) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            Objects.requireNonNull(this.zze, "null reference");
            Objects.requireNonNull(this.zzf, "null reference");
            try {
                zzc = this.zzf.zzc();
            } catch (RemoteException unused) {
                throw new IOException("Remote exception");
            }
        }
        zza();
        return zzc;
    }

    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public final void finish() {
        gj1.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext != null && this.zze != null) {
                try {
                    if (this.zzg) {
                        za2.b().c(this.mContext, this.zze);
                    }
                } catch (Throwable unused) {
                }
                this.zzg = false;
                this.zzf = null;
                this.zze = null;
            }
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        gj1.k("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    a aVar = this.zzi;
                    if (aVar == null || !aVar.i) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            Objects.requireNonNull(this.zze, "null reference");
            Objects.requireNonNull(this.zzf, "null reference");
            try {
                info = new Info(this.zzf.getId(), this.zzf.W0(true));
            } catch (RemoteException unused) {
                throw new IOException("Remote exception");
            }
        }
        zza();
        return info;
    }

    public void start() throws IOException, IllegalStateException, s22, t22 {
        zza(true);
    }

    private static id2 zza(Context context, o22 o22) throws IOException {
        try {
            IBinder a2 = o22.a(Constants.THRESHOLD_TIMESTAMP, TimeUnit.MILLISECONDS);
            int i = jd2.f;
            IInterface queryLocalInterface = a2.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return queryLocalInterface instanceof id2 ? (id2) queryLocalInterface : new kd2(a2);
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
