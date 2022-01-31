package defpackage;

/* renamed from: b53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class b53 {

    /* renamed from: a  reason: collision with root package name */
    public final String f382a;
    public final t53 b;

    public b53(String str, t53 t53) {
        this.f382a = str;
        this.b = t53;
    }

    public final String a(String str, String str2) {
        String str3 = this.f382a;
        int length = String.valueOf(str3).length();
        return hj1.c0(new StringBuilder(length + 5 + str.length() + String.valueOf(str2).length()), str3, str, "?key=", str2);
    }
}
