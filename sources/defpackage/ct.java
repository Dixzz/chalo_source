package defpackage;

import android.content.ComponentName;
import android.content.Context;

/* renamed from: ct  reason: default package */
/* compiled from: PackageManagerHelper */
public class ct {

    /* renamed from: a  reason: collision with root package name */
    public static final String f750a = tp.e("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z) {
        String str;
        String str2 = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            tp c = tp.c();
            String str3 = f750a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            c.a(str3, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e) {
            tp c2 = tp.c();
            String str4 = f750a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            c2.a(str4, String.format("%s could not be %s", objArr2), e);
        }
    }
}
