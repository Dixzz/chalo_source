package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.firebase.iid.ServiceStarter;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: cc5  reason: default package */
/* compiled from: ConfigurationChecker */
public class cc5 {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f548a;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager == null || packageName == null || packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
            return false;
        }
        try {
            ServiceInfo[] serviceInfoArr = packageManager.getPackageInfo(packageName, 4).services;
            if (!(serviceInfoArr == null || serviceInfoArr.length == 0)) {
                Intent intent = new Intent(ServiceStarter.ACTION_MESSAGING_EVENT);
                intent.setPackage(packageName);
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (it.hasNext()) {
                    try {
                        if (!sc5.class.isAssignableFrom(Class.forName(it.next().serviceInfo.name))) {
                            it.remove();
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (queryIntentServices.size() == 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.name.equals(resolveInfo.serviceInfo.name) && serviceInfo.isEnabled()) {
                            arrayList.add(resolveInfo.serviceInfo);
                        }
                    }
                }
                arrayList.size();
                try {
                    Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                    return true;
                } catch (ClassNotFoundException unused2) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
        }
        return false;
    }

    public static boolean b(Context context) {
        if (f548a == null) {
            Intent intent = new Intent(context, TakeoverInAppActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(131072);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
                Boolean bool = Boolean.FALSE;
                f548a = bool;
                return bool.booleanValue();
            }
            f548a = Boolean.TRUE;
        }
        return f548a.booleanValue();
    }
}
