package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: hk6  reason: default package */
/* compiled from: StatusLine.kt */
public final class hk6 {

    /* renamed from: a  reason: collision with root package name */
    public final ii6 f1386a;
    public final int b;
    public final String c;

    public hk6(ii6 ii6, int i, String str) {
        n86.f(ii6, "protocol");
        n86.f(str, "message");
        this.f1386a = ii6;
        this.b = i;
        this.c = str;
    }

    public static final hk6 a(String str) throws IOException {
        ii6 ii6;
        String str2;
        n86.f(str, "statusLine");
        int i = 9;
        if (ea6.G(str, "HTTP/1.", false, 2)) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(hj1.S("Unexpected status line: ", str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                ii6 = ii6.HTTP_1_0;
            } else if (charAt == 1) {
                ii6 = ii6.HTTP_1_1;
            } else {
                throw new ProtocolException(hj1.S("Unexpected status line: ", str));
            }
        } else if (ea6.G(str, "ICY ", false, 2)) {
            ii6 = ii6.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException(hj1.S("Unexpected status line: ", str));
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                String substring = str.substring(i, i2);
                n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                    n86.b(str2, "(this as java.lang.String).substring(startIndex)");
                } else {
                    throw new ProtocolException(hj1.S("Unexpected status line: ", str));
                }
                return new hk6(ii6, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(hj1.S("Unexpected status line: ", str));
            }
        } else {
            throw new ProtocolException(hj1.S("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1386a == ii6.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.c);
        String sb2 = sb.toString();
        n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
