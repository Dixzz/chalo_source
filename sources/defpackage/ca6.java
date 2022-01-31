package defpackage;

import java.io.Serializable;
import java.util.regex.Pattern;

/* renamed from: ca6  reason: default package */
/* compiled from: Regex.kt */
public final class ca6 implements Serializable {
    public final Pattern f;

    public ca6(String str) {
        n86.e(str, "pattern");
        Pattern compile = Pattern.compile(str);
        n86.d(compile, "Pattern.compile(pattern)");
        n86.e(compile, "nativePattern");
        this.f = compile;
    }

    public final boolean a(CharSequence charSequence) {
        n86.e(charSequence, "input");
        return this.f.matcher(charSequence).matches();
    }

    public final String b(CharSequence charSequence, String str) {
        n86.e(charSequence, "input");
        n86.e(str, "replacement");
        String replaceAll = this.f.matcher(charSequence).replaceAll(str);
        n86.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.f.toString();
        n86.d(pattern, "nativePattern.toString()");
        return pattern;
    }
}
