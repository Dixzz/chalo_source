package defpackage;

import androidx.annotation.RecentlyNonNull;

/* renamed from: eb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class eb2 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f953a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @RecentlyNonNull
    public static String a(@RecentlyNonNull byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        int i = 0;
        while (i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0)) {
            char[] cArr = f953a;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
            i++;
        }
        return sb.toString();
    }
}
