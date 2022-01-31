package defpackage;

/* renamed from: md5  reason: default package */
/* compiled from: Base64Coder */
public class md5 {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f2359a = new char[64];
    public static byte[] b = new byte[128];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            f2359a[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            f2359a[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            f2359a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = f2359a;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            b[f2359a[i3]] = (byte) i3;
        }
    }
}
