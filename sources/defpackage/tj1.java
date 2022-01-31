package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: tj1  reason: default package */
/* compiled from: NetworkResponse */
public class tj1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3365a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<pj1> d;
    public final boolean e;

    public tj1(int i, byte[] bArr, Map<String, String> map, List<pj1> list, boolean z, long j) {
        this.f3365a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public tj1(int r9, byte[] r10, boolean r11, long r12, java.util.List<defpackage.pj1> r14) {
        /*
            r8 = this;
            if (r14 != 0) goto L_0x0005
            r0 = 0
        L_0x0003:
            r3 = r0
            goto L_0x002f
        L_0x0005:
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = java.util.Collections.emptyMap()
            goto L_0x0003
        L_0x0010:
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            java.util.Iterator r1 = r14.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0003
            java.lang.Object r2 = r1.next()
            pj1 r2 = (defpackage.pj1) r2
            java.lang.String r3 = r2.f2812a
            java.lang.String r2 = r2.b
            r0.put(r3, r2)
            goto L_0x001b
        L_0x002f:
            r0 = r8
            r1 = r9
            r2 = r10
            r4 = r14
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tj1.<init>(int, byte[], boolean, long, java.util.List):void");
    }
}
