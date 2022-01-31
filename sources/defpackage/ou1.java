package defpackage;

import defpackage.uu1;

/* renamed from: ou1  reason: default package */
/* compiled from: AutoValue_ClientInfo */
public final class ou1 extends uu1 {

    /* renamed from: a  reason: collision with root package name */
    public final uu1.a f2731a;
    public final ku1 b;

    public ou1(uu1.a aVar, ku1 ku1, a aVar2) {
        this.f2731a = aVar;
        this.b = ku1;
    }

    @Override // defpackage.uu1
    public ku1 a() {
        return this.b;
    }

    @Override // defpackage.uu1
    public uu1.a b() {
        return this.f2731a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof uu1)) {
            return false;
        }
        uu1 uu1 = (uu1) obj;
        uu1.a aVar = this.f2731a;
        if (aVar != null ? aVar.equals(uu1.b()) : uu1.b() == null) {
            ku1 ku1 = this.b;
            if (ku1 == null) {
                if (uu1.a() == null) {
                    return true;
                }
            } else if (ku1.equals(uu1.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        uu1.a aVar = this.f2731a;
        int i = 0;
        int hashCode = ((aVar == null ? 0 : aVar.hashCode()) ^ 1000003) * 1000003;
        ku1 ku1 = this.b;
        if (ku1 != null) {
            i = ku1.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ClientInfo{clientType=");
        i0.append(this.f2731a);
        i0.append(", androidClientInfo=");
        i0.append(this.b);
        i0.append("}");
        return i0.toString();
    }
}
