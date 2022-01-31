package defpackage;

/* renamed from: mu1  reason: default package */
/* compiled from: AutoValue_AndroidClientInfo */
public final class mu1 extends ku1 {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f2446a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public mu1(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, a aVar) {
        this.f2446a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }

    @Override // defpackage.ku1
    public String a() {
        return this.l;
    }

    @Override // defpackage.ku1
    public String b() {
        return this.j;
    }

    @Override // defpackage.ku1
    public String c() {
        return this.d;
    }

    @Override // defpackage.ku1
    public String d() {
        return this.h;
    }

    @Override // defpackage.ku1
    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ku1)) {
            return false;
        }
        ku1 ku1 = (ku1) obj;
        Integer num = this.f2446a;
        if (num != null ? num.equals(ku1.l()) : ku1.l() == null) {
            String str = this.b;
            if (str != null ? str.equals(ku1.i()) : ku1.i() == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(ku1.e()) : ku1.e() == null) {
                    String str3 = this.d;
                    if (str3 != null ? str3.equals(ku1.c()) : ku1.c() == null) {
                        String str4 = this.e;
                        if (str4 != null ? str4.equals(ku1.k()) : ku1.k() == null) {
                            String str5 = this.f;
                            if (str5 != null ? str5.equals(ku1.j()) : ku1.j() == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(ku1.g()) : ku1.g() == null) {
                                    String str7 = this.h;
                                    if (str7 != null ? str7.equals(ku1.d()) : ku1.d() == null) {
                                        String str8 = this.i;
                                        if (str8 != null ? str8.equals(ku1.f()) : ku1.f() == null) {
                                            String str9 = this.j;
                                            if (str9 != null ? str9.equals(ku1.b()) : ku1.b() == null) {
                                                String str10 = this.k;
                                                if (str10 != null ? str10.equals(ku1.h()) : ku1.h() == null) {
                                                    String str11 = this.l;
                                                    if (str11 == null) {
                                                        if (ku1.a() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(ku1.a())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.ku1
    public String f() {
        return this.i;
    }

    @Override // defpackage.ku1
    public String g() {
        return this.g;
    }

    @Override // defpackage.ku1
    public String h() {
        return this.k;
    }

    public int hashCode() {
        Integer num = this.f2446a;
        int i2 = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.l;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode11 ^ i2;
    }

    @Override // defpackage.ku1
    public String i() {
        return this.b;
    }

    @Override // defpackage.ku1
    public String j() {
        return this.f;
    }

    @Override // defpackage.ku1
    public String k() {
        return this.e;
    }

    @Override // defpackage.ku1
    public Integer l() {
        return this.f2446a;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("AndroidClientInfo{sdkVersion=");
        i0.append(this.f2446a);
        i0.append(", model=");
        i0.append(this.b);
        i0.append(", hardware=");
        i0.append(this.c);
        i0.append(", device=");
        i0.append(this.d);
        i0.append(", product=");
        i0.append(this.e);
        i0.append(", osBuild=");
        i0.append(this.f);
        i0.append(", manufacturer=");
        i0.append(this.g);
        i0.append(", fingerprint=");
        i0.append(this.h);
        i0.append(", locale=");
        i0.append(this.i);
        i0.append(", country=");
        i0.append(this.j);
        i0.append(", mccMnc=");
        i0.append(this.k);
        i0.append(", applicationBuild=");
        return hj1.a0(i0, this.l, "}");
    }
}
