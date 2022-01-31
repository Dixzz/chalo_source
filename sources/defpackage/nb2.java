package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.RecentlyNonNull;

/* renamed from: nb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class nb2 {
    @RecentlyNonNull

    /* renamed from: a  reason: collision with root package name */
    public final Context f2531a;

    public nb2(@RecentlyNonNull Context context) {
        this.f2531a = context;
    }

    @RecentlyNonNull
    public ApplicationInfo a(@RecentlyNonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.f2531a.getPackageManager().getApplicationInfo(str, i);
    }

    @RecentlyNonNull
    public PackageInfo b(@RecentlyNonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.f2531a.getPackageManager().getPackageInfo(str, i);
    }

    public boolean c() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return mb2.a(this.f2531a);
        }
        if (!gj1.N() || (nameForUid = this.f2531a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f2531a.getPackageManager().isInstantApp(nameForUid);
    }
}
