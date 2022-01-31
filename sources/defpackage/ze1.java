package defpackage;

/* renamed from: ze1  reason: default package */
/* compiled from: InAppCardInfo */
public class ze1 implements Comparable {
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    public String n;
    public long o;
    public boolean p;

    public ze1(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, boolean z, long j3) {
        this.g = str;
        this.i = str2;
        this.k = str3;
        this.h = str4;
        this.j = str5;
        this.f = str6;
        this.n = str7;
        this.o = j2;
        this.m = str8;
        this.p = z;
        this.l = j3;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof ze1) || this.o >= ((ze1) obj).o) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ze1.class != obj.getClass()) {
            return false;
        }
        ze1 ze1 = (ze1) obj;
        if (this.l != ze1.l || this.o != ze1.o || this.p != ze1.p) {
            return false;
        }
        String str = this.f;
        if (str == null ? ze1.f != null : !str.equals(ze1.f)) {
            return false;
        }
        String str2 = this.g;
        if (str2 == null ? ze1.g != null : !str2.equals(ze1.g)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? ze1.h != null : !str3.equals(ze1.h)) {
            return false;
        }
        String str4 = this.i;
        if (str4 == null ? ze1.i != null : !str4.equals(ze1.i)) {
            return false;
        }
        String str5 = this.j;
        if (str5 == null ? ze1.j != null : !str5.equals(ze1.j)) {
            return false;
        }
        String str6 = this.k;
        if (str6 == null ? ze1.k != null : !str6.equals(ze1.k)) {
            return false;
        }
        String str7 = this.m;
        if (str7 == null ? ze1.m != null : !str7.equals(ze1.m)) {
            return false;
        }
        String str8 = this.n;
        String str9 = ze1.n;
        if (str8 != null) {
            return str8.equals(str9);
        }
        if (str9 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.h;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.i;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.j;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.k;
        int hashCode6 = str6 != null ? str6.hashCode() : 0;
        long j2 = this.l;
        int i3 = (((hashCode5 + hashCode6) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str7 = this.m;
        int hashCode7 = (i3 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.n;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        long j3 = this.o;
        return ((((hashCode7 + i2) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.p ? 1 : 0);
    }
}
