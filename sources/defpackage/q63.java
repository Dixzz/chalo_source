package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.RemoteException;
import android.util.Base64;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: q63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class q63 {
    public static final wa2 d = new wa2("FirebaseAuth", "SmsRetrieverHelper");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2905a;
    public final ScheduledExecutorService b;
    public final HashMap<String, p63> c = new HashMap<>();

    public q63(Context context) {
        this.f2905a = context;
        this.b = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }

    public static void f(q63 q63, String str) {
        p63 p63 = q63.c.get(str);
        if (!(p63 == null || gj1.x1(p63.d) || gj1.x1(p63.e) || p63.b.isEmpty())) {
            for (t43 t43 : p63.b) {
                PhoneAuthCredential zzb = PhoneAuthCredential.zzb(p63.d, p63.e);
                Objects.requireNonNull(t43);
                try {
                    t43.f3307a.X(zzb);
                } catch (RemoteException unused) {
                    t43.b.b("RemoteException when sending verification completed response.", new Object[0]);
                }
            }
            p63.h = true;
        }
    }

    public static String g(String str, String str2) {
        String b0 = hj1.b0(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()), str, " ", str2);
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(b0.getBytes(p13.f2758a));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            wa2 wa2 = d;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(substring).length());
            sb.append("Package: ");
            sb.append(str);
            sb.append(" -- Hash: ");
            sb.append(substring);
            wa2.a(sb.toString(), new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            wa2 wa22 = d;
            String valueOf = String.valueOf(e.getMessage());
            wa22.b(valueOf.length() != 0 ? "NoSuchAlgorithm: ".concat(valueOf) : new String("NoSuchAlgorithm: "), new Object[0]);
            return null;
        }
    }

    public final boolean a(String str) {
        return this.c.get(str) != null;
    }

    public final void b(String str, t43 t43, long j, boolean z) {
        this.c.put(str, new p63(j, z));
        c(t43, str);
        p63 p63 = this.c.get(str);
        long j2 = p63.f2772a;
        if (j2 <= 0) {
            d.b("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        p63.f = this.b.schedule(new l63(this, str), j2, TimeUnit.SECONDS);
        if (!p63.c) {
            d.b("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        o63 o63 = new o63(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        this.f2905a.getApplicationContext().registerReceiver(o63, intentFilter);
        new sd2(this.f2905a).a().d(new m63());
    }

    public final void c(t43 t43, String str) {
        p63 p63 = this.c.get(str);
        if (p63 != null) {
            p63.b.add(t43);
            if (p63.g) {
                t43.c(p63.d);
            }
            if (p63.h) {
                PhoneAuthCredential zzb = PhoneAuthCredential.zzb(p63.d, p63.e);
                Objects.requireNonNull(t43);
                try {
                    t43.f3307a.X(zzb);
                } catch (RemoteException unused) {
                    t43.b.b("RemoteException when sending verification completed response.", new Object[0]);
                }
            }
            if (p63.i) {
                String str2 = p63.d;
                Objects.requireNonNull(t43);
                try {
                    t43.f3307a.b1(str2);
                } catch (RemoteException unused2) {
                    t43.b.b("RemoteException when sending auto retrieval timeout response.", new Object[0]);
                }
            }
        }
    }

    public final String d() {
        Signature[] signatureArr;
        try {
            String packageName = this.f2905a.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = ob2.a(this.f2905a).b(packageName, 64).signatures;
            } else {
                signatureArr = ob2.a(this.f2905a).b(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String g = g(packageName, signatureArr[0].toCharsString());
            if (g != null) {
                return g;
            }
            d.b("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            d.b("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    public final void e(String str) {
        p63 p63 = this.c.get(str);
        if (p63 != null) {
            ScheduledFuture<?> scheduledFuture = p63.f;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                p63.f.cancel(false);
            }
            p63.b.clear();
            this.c.remove(str);
        }
    }

    public final void h(String str) {
        p63 p63 = this.c.get(str);
        if (p63 != null) {
            if (!p63.i) {
                i(str);
            }
            e(str);
        }
    }

    public final void i(String str) {
        p63 p63 = this.c.get(str);
        if (p63 != null && !p63.h && !gj1.x1(p63.d)) {
            d.b("Timed out waiting for SMS.", new Object[0]);
            for (t43 t43 : p63.b) {
                String str2 = p63.d;
                Objects.requireNonNull(t43);
                try {
                    t43.f3307a.b1(str2);
                } catch (RemoteException unused) {
                    t43.b.b("RemoteException when sending auto retrieval timeout response.", new Object[0]);
                }
            }
            p63.i = true;
        }
    }
}
