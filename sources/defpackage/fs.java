package defpackage;

/* renamed from: fs  reason: default package */
/* compiled from: Preference */
public class fs {

    /* renamed from: a  reason: collision with root package name */
    public String f1166a;
    public Long b;

    public fs(String str, long j) {
        this.f1166a = str;
        this.b = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fs)) {
            return false;
        }
        fs fsVar = (fs) obj;
        if (!this.f1166a.equals(fsVar.f1166a)) {
            return false;
        }
        Long l = this.b;
        Long l2 = fsVar.b;
        if (l != null) {
            return l.equals(l2);
        }
        if (l2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f1166a.hashCode() * 31;
        Long l = this.b;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public fs(String str, boolean z) {
        long j = z ? 1 : 0;
        this.f1166a = str;
        this.b = Long.valueOf(j);
    }
}
