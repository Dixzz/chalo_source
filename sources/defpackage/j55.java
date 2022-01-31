package defpackage;

import java.nio.charset.StandardCharsets;

/* renamed from: j55  reason: default package */
/* compiled from: EncoderContext */
public final class j55 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1880a;
    public m55 b;
    public t25 c;
    public t25 d;
    public final StringBuilder e;
    public int f;
    public int g;
    public l55 h;
    public int i;

    public j55(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f1880a = sb.toString();
        this.b = m55.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    public int a() {
        return this.e.length();
    }

    public char b() {
        return this.f1880a.charAt(this.f);
    }

    public int c() {
        return (this.f1880a.length() - this.i) - this.f;
    }

    public boolean d() {
        return this.f < this.f1880a.length() - this.i;
    }

    public void e() {
        f(a());
    }

    public void f(int i2) {
        l55 l55 = this.h;
        if (l55 == null || i2 > l55.b) {
            this.h = l55.i(i2, this.b, this.c, this.d, true);
        }
    }
}
