package defpackage;

/* renamed from: js3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class js3 extends is3<Long> {
    public js3(ns3 ns3, String str, Long l) {
        super(ns3, str, l, true, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.is3
    public final Long a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String c = c();
        String valueOf = String.valueOf(obj);
        String.valueOf(c).length();
        valueOf.length();
        return null;
    }
}
