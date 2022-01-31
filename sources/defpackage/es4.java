package defpackage;

/* renamed from: es4  reason: default package */
public final class es4 extends jr4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1025a;
    public final String b;

    public es4(int i, String str, String str2) {
        this.f1025a = str;
        this.b = str2;
    }

    @Override // defpackage.jr4
    public final String a() {
        return this.b;
    }

    @Override // defpackage.jr4
    public final int b() {
        return 0;
    }

    @Override // defpackage.jr4
    public final String c() {
        return this.f1025a;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof jr4) {
            jr4 jr4 = (jr4) obj;
            if (jr4.b() == 0 && ((str = this.f1025a) != null ? str.equals(jr4.c()) : jr4.c() == null)) {
                String str2 = this.b;
                String a2 = jr4.a();
                if (str2 != null ? str2.equals(a2) : a2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1025a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ -721379959) * 1000003;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.f1025a;
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(0);
        sb.append(", path=");
        sb.append(str);
        return hj1.b0(sb, ", assetsPath=", str2, "}");
    }
}
