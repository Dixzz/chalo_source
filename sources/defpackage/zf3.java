package defpackage;

/* renamed from: zf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zf3 extends yf3<Boolean> {
    public zf3(cg3 cg3, String str, Boolean bool) {
        super(cg3, str, bool, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.yf3
    public final /* synthetic */ Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (hf3.c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (hf3.d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String c = c();
        String valueOf = String.valueOf(obj);
        String.valueOf(c).length();
        valueOf.length();
        return null;
    }
}
