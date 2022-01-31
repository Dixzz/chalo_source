package defpackage;

/* renamed from: p86  reason: default package */
/* compiled from: PackageReference.kt */
public final class p86 implements g86 {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f2781a;

    public p86(Class<?> cls, String str) {
        n86.e(cls, "jClass");
        n86.e(str, "moduleName");
        this.f2781a = cls;
    }

    @Override // defpackage.g86
    public Class<?> a() {
        return this.f2781a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p86) && n86.a(this.f2781a, ((p86) obj).f2781a);
    }

    public int hashCode() {
        return this.f2781a.hashCode();
    }

    public String toString() {
        return this.f2781a.toString() + " (Kotlin reflection is not available)";
    }
}
