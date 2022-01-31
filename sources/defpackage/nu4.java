package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: nu4  reason: default package */
public final class nu4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2606a;

    public nu4(Context context) {
        this.f2606a = context;
    }

    public static String a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
