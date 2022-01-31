package defpackage;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import androidx.annotation.RecentlyNonNull;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: za2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class za2 {
    public static final Object b = new Object();
    @Nullable
    public static volatile za2 c;
    @RecentlyNonNull

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> f4151a = new ConcurrentHashMap<>();

    @RecentlyNonNull
    public static za2 b() {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new za2();
                }
            }
        }
        za2 za2 = c;
        Objects.requireNonNull(za2, "null reference");
        return za2;
    }

    public boolean a(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, int i) {
        return d(context, context.getClass().getName(), intent, serviceConnection, i, true);
    }

    @SuppressLint({"UntrackedBindService"})
    public void c(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        if (!(!(serviceConnection instanceof na2)) || !this.f4151a.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService((ServiceConnection) this.f4151a.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
                }
            } finally {
                this.f4151a.remove(serviceConnection);
            }
        }
    }

    @SuppressLint({"UntrackedBindService"})
    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((ob2.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!(!(serviceConnection instanceof na2))) {
            return context.bindService(intent, serviceConnection, i);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f4151a.putIfAbsent(serviceConnection, serviceConnection);
        if (!(serviceConnection2 == null || serviceConnection == serviceConnection2)) {
            String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction());
        }
        try {
            boolean bindService = context.bindService(intent, serviceConnection, i);
            if (bindService) {
                return bindService;
            }
            return false;
        } finally {
            this.f4151a.remove(serviceConnection, serviceConnection);
        }
    }
}
