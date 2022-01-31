package defpackage;

/* renamed from: qc  reason: default package */
/* compiled from: LazyFieldLite */
public class qc {

    /* renamed from: a  reason: collision with root package name */
    public volatile dd f2927a;
    public volatile ub b;

    static {
        cc.a();
    }

    public dd a(dd ddVar) {
        if (this.f2927a == null) {
            synchronized (this) {
                if (this.f2927a == null) {
                    try {
                        this.f2927a = ddVar;
                        this.b = ub.g;
                    } catch (nc unused) {
                        this.f2927a = ddVar;
                        this.b = ub.g;
                    }
                }
            }
        }
        return this.f2927a;
    }

    public ub b() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            if (this.f2927a == null) {
                this.b = ub.g;
            } else {
                this.b = this.f2927a.toByteString();
            }
            return this.b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qc)) {
            return false;
        }
        qc qcVar = (qc) obj;
        dd ddVar = this.f2927a;
        dd ddVar2 = qcVar.f2927a;
        if (ddVar == null && ddVar2 == null) {
            return b().equals(qcVar.b());
        }
        if (ddVar != null && ddVar2 != null) {
            return ddVar.equals(ddVar2);
        }
        if (ddVar != null) {
            return ddVar.equals(qcVar.a(ddVar.getDefaultInstanceForType()));
        }
        return a(ddVar2.getDefaultInstanceForType()).equals(ddVar2);
    }

    public int hashCode() {
        return 1;
    }
}
