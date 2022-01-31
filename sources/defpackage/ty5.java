package defpackage;

import defpackage.vy5;

/* renamed from: ty5  reason: default package */
/* compiled from: IvyVersionMatcher */
public final class ty5 implements dk5<String> {
    public final /* synthetic */ String f;
    public final /* synthetic */ vy5.a g;
    public final /* synthetic */ String h;
    public final /* synthetic */ vy5.a i;

    public ty5(String str, vy5.a aVar, String str2, vy5.a aVar2) {
        this.f = str;
        this.g = aVar;
        this.h = str2;
        this.i = aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.dk5
    public boolean apply(String str) {
        try {
            vy5.a aVar = new vy5.a(str);
            String str2 = this.f;
            if (!(str2 == null || this.g == null)) {
                if (!str2.equals("[")) {
                    if (str2.equals("]") && aVar.compareTo(this.g) > 0) {
                        return false;
                    }
                } else if (aVar.compareTo(this.g) >= 0) {
                    return false;
                }
            }
            String str3 = this.h;
            if (!(str3 == null || this.i == null)) {
                if (!str3.equals("[")) {
                    if (str3.equals("]") && aVar.compareTo(this.i) <= 0) {
                        return false;
                    }
                } else if (aVar.compareTo(this.i) < 0) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
