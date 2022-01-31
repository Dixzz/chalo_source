package j$.time.format;

import j$.com.android.tools.r8.a;
import j$.util.concurrent.ConcurrentHashMap;

public final class g {
    public static final g e = new g('0', '+', '-', '.');

    /* renamed from: a  reason: collision with root package name */
    private final char f1616a;
    private final char b;
    private final char c;
    private final char d;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private g(char c2, char c3, char c4, char c5) {
        this.f1616a = c2;
        this.b = c3;
        this.c = c4;
        this.d = c5;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        char c2 = this.f1616a;
        if (c2 == '0') {
            return str;
        }
        int i = c2 - '0';
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] + i);
        }
        return new String(charArray);
    }

    public char b() {
        return this.d;
    }

    public char c() {
        return this.c;
    }

    public char d() {
        return this.b;
    }

    public char e() {
        return this.f1616a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f1616a == gVar.f1616a && this.b == gVar.b && this.c == gVar.c && this.d == gVar.d;
    }

    public int hashCode() {
        return this.f1616a + this.b + this.c + this.d;
    }

    public String toString() {
        StringBuilder a2 = a.a("DecimalStyle[");
        a2.append(this.f1616a);
        a2.append(this.b);
        a2.append(this.c);
        a2.append(this.d);
        a2.append("]");
        return a2.toString();
    }
}
