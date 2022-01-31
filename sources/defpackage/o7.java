package defpackage;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import defpackage.r7;
import java.util.Locale;

/* renamed from: o7  reason: default package */
/* compiled from: BidiFormatter */
public final class o7 {
    public static final q7 d;
    public static final String e = Character.toString(8206);
    public static final String f = Character.toString(8207);
    public static final o7 g;
    public static final o7 h;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2657a;
    public final int b;
    public final q7 c;

    /* renamed from: o7$a */
    /* compiled from: BidiFormatter */
    public static class a {
        public static final byte[] e = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f2658a;
        public final int b;
        public int c;
        public char d;

        static {
            for (int i = 0; i < 1792; i++) {
                e[i] = Character.getDirectionality(i);
            }
        }

        public a(CharSequence charSequence, boolean z) {
            this.f2658a = charSequence;
            this.b = charSequence.length();
        }

        public byte a() {
            char charAt = this.f2658a.charAt(this.c - 1);
            this.d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f2658a, this.c);
                this.c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.c--;
            char c2 = this.d;
            return c2 < 1792 ? e[c2] : Character.getDirectionality(c2);
        }
    }

    static {
        q7 q7Var = r7.c;
        d = q7Var;
        g = new o7(false, 2, q7Var);
        h = new o7(true, 2, q7Var);
    }

    public o7(boolean z, int i, q7 q7Var) {
        this.f2657a = z;
        this.b = i;
        this.c = q7Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.CharSequence r9) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o7.a(java.lang.CharSequence):int");
    }

    public static int b(CharSequence charSequence) {
        a aVar = new a(charSequence, false);
        aVar.c = aVar.b;
        int i = 0;
        int i2 = 0;
        while (aVar.c > 0) {
            byte a2 = aVar.a();
            if (a2 != 0) {
                if (a2 == 1 || a2 == 2) {
                    if (i != 0) {
                        if (i2 != 0) {
                        }
                        i2 = i;
                    }
                } else if (a2 != 9) {
                    switch (a2) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                break;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                break;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            }
                            i2 = i;
                            break;
                    }
                } else {
                    continue;
                }
                return 1;
            } else if (i != 0) {
                if (i2 != 0) {
                }
                i2 = i;
            }
            return -1;
        }
        return 0;
    }

    public static o7 c() {
        Locale locale = Locale.getDefault();
        Locale locale2 = s7.f3193a;
        boolean z = true;
        if (TextUtils.getLayoutDirectionFromLocale(locale) != 1) {
            z = false;
        }
        q7 q7Var = d;
        if (q7Var == d) {
            return z ? h : g;
        }
        return new o7(z, 2, q7Var);
    }

    public CharSequence d(CharSequence charSequence, q7 q7Var, boolean z) {
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean b2 = ((r7.c) q7Var).b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = "";
        if (((this.b & 2) != 0) && z) {
            boolean b3 = ((r7.c) (b2 ? r7.b : r7.f3050a)).b(charSequence, 0, charSequence.length());
            if (this.f2657a || (!b3 && a(charSequence) != 1)) {
                str = (!this.f2657a || (b3 && a(charSequence) != -1)) ? str2 : f;
            } else {
                str = e;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        if (b2 != this.f2657a) {
            spannableStringBuilder.append(b2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean b4 = ((r7.c) (b2 ? r7.b : r7.f3050a)).b(charSequence, 0, charSequence.length());
            if (!this.f2657a && (b4 || b(charSequence) == 1)) {
                str2 = e;
            } else if (this.f2657a && (!b4 || b(charSequence) == -1)) {
                str2 = f;
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        return spannableStringBuilder;
    }
}
