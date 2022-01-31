package defpackage;

/* renamed from: jd3  reason: default package */
public final class jd3<V> {

    /* renamed from: a  reason: collision with root package name */
    public final V f1906a;

    public jd3(o72<V> o72, V v) {
        this.f1906a = v;
    }

    public static jd3<Integer> a(String str, int i, int i2) {
        return new jd3<>(new r72(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    public static jd3<Long> b(String str, long j, long j2) {
        return new jd3<>(new q72(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    public static jd3<String> c(String str, String str2, String str3) {
        return new jd3<>(new t72(str, str3), str2);
    }

    public static jd3<Boolean> d(String str, boolean z, boolean z2) {
        return new jd3<>(new p72(str, Boolean.valueOf(z2)), Boolean.valueOf(z));
    }
}
