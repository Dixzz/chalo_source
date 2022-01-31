package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: o12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public class o12 {
    public static int h;
    public static PendingIntent i;
    @GuardedBy("responseCallbacks")

    /* renamed from: a  reason: collision with root package name */
    public final u2<String, zi4<Bundle>> f2632a = new u2<>();
    public final Context b;
    public final f22 c;
    public final ScheduledExecutorService d;
    public Messenger e;
    public Messenger f;
    public zza g;

    public o12(Context context) {
        this.b = context;
        this.c = new f22(context);
        this.e = new Messenger(new m22(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.d = scheduledThreadPoolExecutor;
    }

    public yi4<Bundle> a(Bundle bundle) {
        boolean z;
        int i2;
        int i3;
        PackageInfo packageInfo;
        Executor executor = n22.f;
        f22 f22 = this.c;
        synchronized (f22) {
            z = false;
            if (f22.b == 0) {
                try {
                    packageInfo = ob2.a(f22.f1063a).f2531a.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    String.valueOf(e2).length();
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    f22.b = packageInfo.versionCode;
                }
            }
            i2 = f22.b;
        }
        if (i2 >= 12000000) {
            s12 a2 = s12.a(this.b);
            synchronized (a2) {
                i3 = a2.d;
                a2.d = i3 + 1;
            }
            return a2.b(new g22(i3, bundle)).i(executor, h22.f1333a);
        }
        if (this.c.a() != 0) {
            z = true;
        }
        if (!z) {
            return hd3.V0(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return c(bundle).k(executor, new j22(this, bundle));
    }

    public final void b(String str, Bundle bundle) {
        synchronized (this.f2632a) {
            zi4<Bundle> remove = this.f2632a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Missing callback for ".concat(valueOf);
                } else {
                    new String("Missing callback for ");
                }
                return;
            }
            remove.f4178a.t(bundle);
        }
    }

    public final yi4<Bundle> c(Bundle bundle) {
        String num;
        synchronized (o12.class) {
            int i2 = h;
            h = i2 + 1;
            num = Integer.toString(i2);
        }
        zi4<Bundle> zi4 = new zi4<>();
        synchronized (this.f2632a) {
            this.f2632a.put(num, zi4);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.c.a() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.b;
        synchronized (o12.class) {
            if (i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                i = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(SettingsJsonConstants.APP_KEY, i);
        }
        intent.putExtra("kid", hj1.y(hj1.g0(num, 5), "|ID|", num, "|"));
        if (Log.isLoggable("Rpc", 3)) {
            String.valueOf(intent.getExtras()).length();
        }
        intent.putExtra("google.messenger", this.e);
        if (!(this.f == null && this.g == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    Messenger messenger2 = this.g.f;
                    Objects.requireNonNull(messenger2);
                    messenger2.send(obtain);
                }
            } catch (RemoteException unused) {
            }
            ScheduledFuture<?> schedule = this.d.schedule(new i22(zi4), 30, TimeUnit.SECONDS);
            wj4<TResult> wj4 = zi4.f4178a;
            wj4.b.a(new lj4(n22.f, new l22(this, num, schedule)));
            wj4.x();
            return zi4.f4178a;
        }
        if (this.c.a() == 2) {
            this.b.sendBroadcast(intent);
        } else {
            this.b.startService(intent);
        }
        ScheduledFuture<?> schedule2 = this.d.schedule(new i22(zi4), 30, TimeUnit.SECONDS);
        wj4<TResult> wj42 = zi4.f4178a;
        wj42.b.a(new lj4(n22.f, new l22(this, num, schedule2)));
        wj42.x();
        return zi4.f4178a;
    }
}
