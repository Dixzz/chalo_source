package defpackage;

/* renamed from: ge3  reason: default package */
public final class ge3 extends xb3 implements zc3<he3> {
    public final he3 g = new he3();

    public ge3(ac3 ac3) {
        super(ac3);
    }

    /* Return type fixed from 'xc3' to match base method */
    @Override // defpackage.zc3
    public final /* synthetic */ he3 c() {
        return this.g;
    }

    @Override // defpackage.zc3
    public final void e(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.g.c = i;
        } else {
            J("int configuration name not recognized", str);
        }
    }

    @Override // defpackage.zc3
    public final void f(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.g.f1362a = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.g.b = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                r("Error parsing ga_sampleFrequency value", str2, e);
            }
        } else {
            J("string configuration name not recognized", str);
        }
    }

    @Override // defpackage.zc3
    public final void g(String str, String str2) {
        this.g.g.put(str, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.zc3
    public final void i(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.g.d = z;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.g.e = z;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.g.f = z ? 1 : 0;
        } else {
            J("bool configuration name not recognized", str);
        }
    }
}
