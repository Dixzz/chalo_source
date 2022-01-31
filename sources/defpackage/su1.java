package defpackage;

import defpackage.yu1;

/* renamed from: su1  reason: default package */
/* compiled from: AutoValue_NetworkConnectionInfo */
public final class su1 extends yu1 {

    /* renamed from: a  reason: collision with root package name */
    public final yu1.b f3258a;
    public final yu1.a b;

    public su1(yu1.b bVar, yu1.a aVar, a aVar2) {
        this.f3258a = bVar;
        this.b = aVar;
    }

    @Override // defpackage.yu1
    public yu1.a a() {
        return this.b;
    }

    @Override // defpackage.yu1
    public yu1.b b() {
        return this.f3258a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yu1)) {
            return false;
        }
        yu1 yu1 = (yu1) obj;
        yu1.b bVar = this.f3258a;
        if (bVar != null ? bVar.equals(yu1.b()) : yu1.b() == null) {
            yu1.a aVar = this.b;
            if (aVar == null) {
                if (yu1.a() == null) {
                    return true;
                }
            } else if (aVar.equals(yu1.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        yu1.b bVar = this.f3258a;
        int i = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        yu1.a aVar = this.b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("NetworkConnectionInfo{networkType=");
        i0.append(this.f3258a);
        i0.append(", mobileSubtype=");
        i0.append(this.b);
        i0.append("}");
        return i0.toString();
    }
}
