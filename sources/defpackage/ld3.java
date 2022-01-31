package defpackage;

/* renamed from: ld3  reason: default package */
public final class ld3 implements zc3<md3> {
    public final ac3 f;
    public final md3 g = new md3();

    public ld3(ac3 ac3) {
        this.f = ac3;
    }

    /* Return type fixed from 'xc3' to match base method */
    @Override // defpackage.zc3
    public final /* synthetic */ md3 c() {
        return this.g;
    }

    @Override // defpackage.zc3
    public final void e(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.g.d = i;
        } else {
            this.f.c().J("Int xml configuration name not recognized", str);
        }
    }

    @Override // defpackage.zc3
    public final void f(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.g.f2358a = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.g.b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.g.c = str2;
        } else {
            this.f.c().J("String xml configuration name not recognized", str);
        }
    }

    @Override // defpackage.zc3
    public final void g(String str, String str2) {
    }

    @Override // defpackage.zc3
    public final void i(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.g.e = z ? 1 : 0;
            return;
        }
        this.f.c().J("Bool xml configuration name not recognized", str);
    }
}
