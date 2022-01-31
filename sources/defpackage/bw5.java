package defpackage;

import android.content.Context;
import com.urbanairship.AirshipConfigOptions;

/* renamed from: bw5  reason: default package */
/* compiled from: AirshipNotificationProvider */
public class bw5 implements jw5 {

    /* renamed from: a  reason: collision with root package name */
    public int f484a;
    public int b;
    public int c;
    public int d;
    public String e;

    public bw5(Context context, AirshipConfigOptions airshipConfigOptions) {
        this.f484a = context.getApplicationInfo().labelRes;
        int i = airshipConfigOptions.x;
        this.b = i;
        this.c = airshipConfigOptions.y;
        this.d = airshipConfigOptions.z;
        String str = airshipConfigOptions.A;
        if (str != null) {
            this.e = str;
        } else {
            this.e = "com.urbanairship.default";
        }
        if (i == 0) {
            this.b = context.getApplicationInfo().icon;
        }
        this.f484a = context.getApplicationInfo().labelRes;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c4 A[Catch:{ NumberFormatException -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c5 A[Catch:{ NumberFormatException -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.kw5 a(android.content.Context r9, defpackage.ew5 r10) {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bw5.a(android.content.Context, ew5):kw5");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.ew5 b(android.content.Context r9, com.urbanairship.push.PushMessage r10) {
        /*
        // Method dump skipped, instructions count: 155
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bw5.b(android.content.Context, com.urbanairship.push.PushMessage):ew5");
    }
}
