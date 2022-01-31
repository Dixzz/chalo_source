package defpackage;

/* renamed from: ls3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ls3 extends is3<Double> {
    public ls3(ns3 ns3, String str, Double d) {
        super(ns3, str, d, true, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.is3
    public final Double a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
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
