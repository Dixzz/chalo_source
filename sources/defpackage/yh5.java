package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.lang.reflect.Array;

@TargetApi(22)
/* renamed from: yh5  reason: default package */
/* compiled from: SamsungCallLogInfoUtil */
public class yh5 extends xh5 {
    public static final Uri d = Uri.parse("content://logs/call");

    static {
        String[] strArr = wh5.f3783a;
        String[] strArr2 = {"normalized_number", SettingsJsonConstants.FEATURES_KEY, "subscription_component_name", "logtype"};
        Class<?> componentType = strArr.getClass().getComponentType();
        Object[] objArr = (Object[]) Array.newInstance(componentType, strArr.length + 4);
        System.arraycopy(strArr, 0, objArr, 0, strArr.length);
        try {
            System.arraycopy(strArr2, 0, objArr, strArr.length, 4);
            String[] strArr3 = (String[]) objArr;
        } catch (ArrayStoreException e) {
            Class<?> componentType2 = strArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                StringBuilder i0 = hj1.i0("Cannot store ");
                i0.append(componentType2.getName());
                i0.append(" in an array of ");
                i0.append(componentType.getName());
                throw new IllegalArgumentException(i0.toString(), e);
            }
            throw e;
        }
    }

    public yh5(Context context) {
        super(context);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r18) {
        /*
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "samsung"
            boolean r0 = r1.equalsIgnoreCase(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            java.lang.String r2 = "_id"
            java.lang.String r3 = "name"
            java.lang.String r4 = "date"
            java.lang.String r5 = "features"
            java.lang.String r6 = "new"
            java.lang.String r7 = "is_read"
            java.lang.String r8 = "subscription_component_name"
            java.lang.String r9 = "number"
            java.lang.String r10 = "type"
            java.lang.String r11 = "duration"
            java.lang.String[] r14 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11}
            r0 = 1
            android.content.ContentResolver r12 = r18.getContentResolver()     // Catch:{ SecurityException -> 0x0040, Exception -> 0x003f }
            android.net.Uri r13 = defpackage.yh5.d     // Catch:{ SecurityException -> 0x0040, Exception -> 0x003f }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ SecurityException -> 0x0040, Exception -> 0x003f }
            if (r2 == 0) goto L_0x0039
            r2.close()
        L_0x0039:
            if (r2 == 0) goto L_0x003c
            r1 = 1
        L_0x003c:
            return r1
        L_0x003d:
            r0 = move-exception
            goto L_0x0053
        L_0x003f:
            return r1
        L_0x0040:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x003d }
            r3 = 23
            if (r2 < r3) goto L_0x0052
            java.lang.String r2 = "android.permission.READ_CALL_LOG"
            r3 = r18
            int r2 = r3.checkSelfPermission(r2)     // Catch:{ all -> 0x003d }
            r3 = -1
            if (r2 != r3) goto L_0x0052
            r1 = 1
        L_0x0052:
            return r1
        L_0x0053:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yh5.a(android.content.Context):boolean");
    }
}
