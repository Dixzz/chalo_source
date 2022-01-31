package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Objects;

/* renamed from: ob4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ob4 {

    /* renamed from: a  reason: collision with root package name */
    public final rb4 f2675a;

    public ob4(rb4 rb4) {
        this.f2675a = rb4;
    }

    public static boolean a(Context context) {
        ActivityInfo receiverInfo;
        Objects.requireNonNull(context, "null reference");
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
