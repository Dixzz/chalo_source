package defpackage;

/* renamed from: gr4  reason: default package */
public final class gr4 extends pq4 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1297a;
    public final boolean b;

    public /* synthetic */ gr4(int i, boolean z) {
        this.f1297a = i;
        this.b = z;
    }

    @Override // defpackage.pq4
    public final boolean a() {
        return this.b;
    }

    @Override // defpackage.pq4
    public final int b() {
        return this.f1297a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof pq4) {
            pq4 pq4 = (pq4) obj;
            return this.f1297a == pq4.b() && this.b == pq4.a();
        }
    }

    public final int hashCode() {
        return ((this.f1297a ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.f1297a;
        boolean z = this.b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
