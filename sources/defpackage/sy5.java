package defpackage;

/* renamed from: sy5  reason: default package */
/* compiled from: IvyVersionMatcher */
public final class sy5 implements dk5<String> {
    public final /* synthetic */ String f;

    public sy5(String str) {
        this.f = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.dk5
    public boolean apply(String str) {
        String str2 = str;
        String str3 = this.f;
        if (str3 == null) {
            return false;
        }
        return str2.startsWith(str3);
    }
}
