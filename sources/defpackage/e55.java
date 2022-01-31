package defpackage;

/* renamed from: e55  reason: default package */
/* compiled from: C40Encoder */
public class e55 implements i55 {
    public static void f(j55 j55, StringBuilder sb) {
        char charAt = sb.charAt(0);
        int charAt2 = (sb.charAt(1) * '(') + (charAt * 1600) + sb.charAt(2) + 1;
        j55.e.append(new String(new char[]{(char) (charAt2 / 256), (char) (charAt2 % 256)}));
        sb.delete(0, 3);
    }

    @Override // defpackage.i55
    public void a(j55 j55) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!j55.d()) {
                break;
            }
            char b = j55.b();
            j55.f++;
            int c = c(b, sb);
            int a2 = j55.a() + ((sb.length() / 3) << 1);
            j55.f(a2);
            int i = j55.h.b - a2;
            if (j55.d()) {
                if (sb.length() % 3 == 0 && hd3.e2(j55.f1880a, j55.f, d()) != d()) {
                    j55.g = 0;
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i < 2 || i > 2)) {
                    c = b(j55, sb, sb2, c);
                }
                while (sb.length() % 3 == 1 && ((c <= 3 && i != 1) || c > 3)) {
                    c = b(j55, sb, sb2, c);
                }
            }
        }
        e(j55, sb);
    }

    public final int b(j55 j55, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        j55.f--;
        int c = c(j55.b(), sb2);
        j55.h = null;
        return c;
    }

    public int c(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c < '`' || c > 127) {
            sb.append("\u0001\u001e");
            return c((char) (c - 128), sb) + 2;
        } else {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
    }

    public int d() {
        return 1;
    }

    public void e(j55 j55, StringBuilder sb) {
        int length = sb.length() % 3;
        int a2 = j55.a() + ((sb.length() / 3) << 1);
        j55.f(a2);
        int i = j55.h.b - a2;
        if (length == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                f(j55, sb);
            }
            if (j55.d()) {
                j55.e.append((char) 254);
            }
        } else if (i == 1 && length == 1) {
            while (sb.length() >= 3) {
                f(j55, sb);
            }
            if (j55.d()) {
                j55.e.append((char) 254);
            }
            j55.f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                f(j55, sb);
            }
            if (i > 0 || j55.d()) {
                j55.e.append((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        j55.g = 0;
    }
}
