package defpackage;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.io.PrintWriter;

/* renamed from: y7  reason: default package */
/* compiled from: TimeUtils */
public final class y7 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f4011a = new Object();
    public static char[] b = new char[24];

    public static int a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    public static void b(long j, PrintWriter printWriter, int i) {
        synchronized (f4011a) {
            printWriter.print(new String(b, 0, c(j, i)));
        }
    }

    public static int c(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2 = j;
        if (b.length < i) {
            b = new char[i];
        }
        char[] cArr = b;
        int i7 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i7 == 0) {
            int i8 = i - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i7 > 0) {
            c = '+';
        } else {
            c = '-';
            j2 = -j2;
        }
        int i9 = (int) (j2 % 1000);
        int floor = (int) Math.floor((double) (j2 / 1000));
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
            floor -= i3 * SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i10 = floor / 60;
            i4 = floor - (i10 * 60);
            i5 = i10;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i != 0) {
            int a2 = a(i2, 1, false, 0);
            int a3 = a(i3, 1, a2 > 0, 2) + a2;
            int a4 = a(i5, 1, a3 > 0, 2) + a3;
            int a5 = a(i4, 1, a4 > 0, 2) + a4;
            i6 = 0;
            for (int a6 = a(i9, 2, true, a5 > 0 ? 3 : 0) + 1 + a5; a6 < i; a6++) {
                cArr[i6] = ' ';
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i11 = i6 + 1;
        boolean z = i != 0;
        int d = d(cArr, i2, 'd', i11, false, 0);
        int d2 = d(cArr, i3, 'h', d, d != i11, z ? 2 : 0);
        int d3 = d(cArr, i5, 'm', d2, d2 != i11, z ? 2 : 0);
        int d4 = d(cArr, i4, 's', d3, d3 != i11, z ? 2 : 0);
        int d5 = d(cArr, i9, 'm', d4, true, (!z || d4 == i11) ? 0 : 3);
        cArr[d5] = 's';
        return d5 + 1;
    }

    public static int d(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= 2) || i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        int i7 = i4 + 1;
        cArr[i7] = c;
        return i7 + 1;
    }
}
