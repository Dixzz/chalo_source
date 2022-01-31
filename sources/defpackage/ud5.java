package defpackage;

/* renamed from: ud5  reason: default package */
/* compiled from: RemoteService */
public interface ud5 {

    /* renamed from: ud5$a */
    /* compiled from: RemoteService */
    public static class a extends Exception {
        public final int f;

        public a(String str, String str2) {
            super(str);
            int i;
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                i = 0;
            }
            this.f = i;
        }
    }
}
