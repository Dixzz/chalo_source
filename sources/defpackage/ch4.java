package defpackage;

import java.util.Map;
import java.util.Set;

/* renamed from: ch4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ch4 extends jg4 {
    public String d;
    public Set<Integer> e;
    public Map<Integer, eh4> f;
    public Long g;
    public Long h;

    public ch4(lg4 lg4) {
        super(lg4);
    }

    @Override // defpackage.jg4
    public final boolean n() {
        return false;
    }

    public final eh4 q(int i) {
        if (this.f.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i));
        }
        eh4 eh4 = new eh4(this, this.d, null);
        this.f.put(Integer.valueOf(i), eh4);
        return eh4;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:391:0x0356 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:394:0x0356 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v112, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v117, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v121 */
    /* JADX WARN: Type inference failed for: r0v128, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v146, types: [java.util.Map] */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0314, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0315, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0472, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0711, code lost:
        if (r62.f3331a.g.t(r62.d, defpackage.q64.F0) == false) goto L_0x0716;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0314 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:119:0x02ba] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0332 A[Catch:{ all -> 0x046e }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0577  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0639  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x07d8  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0959  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x09e0  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x057e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01bb A[Catch:{ SQLiteException -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01db  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<defpackage.sq3> s(java.lang.String r63, java.util.List<defpackage.uq3> r64, java.util.List<defpackage.cr3> r65, java.lang.Long r66, java.lang.Long r67) {
        /*
        // Method dump skipped, instructions count: 2532
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ch4.s(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final boolean t(int i, int i2) {
        if (this.f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f.get(Integer.valueOf(i)).d.get(i2);
    }
}
