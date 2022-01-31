package defpackage;

/* renamed from: ms3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ms3 extends is3<Boolean> {
    public ms3(ns3 ns3, String str, Boolean bool) {
        super(ns3, str, bool, true, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.is3
    public final /* synthetic */ Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (rr3.c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (rr3.d.matcher(str).matches()) {
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
