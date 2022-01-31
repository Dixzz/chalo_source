package defpackage;

import java.util.List;

/* renamed from: re1  reason: default package */
/* compiled from: Alert */
public class re1 implements Comparable {
    public String f;
    public String g;
    public String h;
    public String i;
    public long j;
    public boolean k;
    public se1 l;
    public List<String> m;
    public boolean n;
    public String o = "ALERT";
    public String p;
    public long q;

    public re1(String str, long j2, String str2, String str3, String str4, boolean z, se1 se1) {
        this.j = j2;
        this.i = str2;
        this.h = str3;
        this.g = str4;
        this.f = str;
        this.k = z;
        this.l = se1;
    }

    public String a() {
        String str = this.o;
        return str == null ? "ALERT" : str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof re1) || ((re1) obj).j < this.j) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || re1.class != obj.getClass()) {
            return false;
        }
        re1 re1 = (re1) obj;
        if (this.j != re1.j || !this.f.equals(re1.f) || !this.g.equals(re1.g) || !this.h.equals(re1.h)) {
            return false;
        }
        String str = this.i;
        String str2 = re1.i;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.h, hj1.r0(this.g, this.f.hashCode() * 31, 31), 31);
        String str = this.i;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.j;
        return ((r0 + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }
}
