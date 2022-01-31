package defpackage;

/* renamed from: v55  reason: default package */
/* compiled from: Code128Reader */
public final class v55 extends k65 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f3604a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX DEBUG: Multi-variable search result rejected for r28v0, resolved type: e45 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a5, code lost:
        if (r13 != false) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a7, code lost:
        r12 = false;
        r13 = false;
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0152, code lost:
        if (r13 != false) goto L_0x01a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b2 A[PHI: r24 
      PHI: (r24v9 boolean) = (r24v13 boolean), (r24v16 boolean) binds: [B:89:0x0180, B:67:0x0132] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01bb A[PHI: r4 r23 r24 
      PHI: (r4v20 char) = (r4v8 char), (r4v22 char), (r4v8 char), (r4v24 char), (r4v8 char), (r4v8 char), (r4v8 char), (r4v8 char), (r4v8 char), (r4v26 char), (r4v8 char), (r4v8 char), (r4v8 char) binds: [B:51:0x00f7, B:103:0x01b2, B:89:0x0180, B:95:0x0196, B:90:0x0184, B:94:0x0190, B:93:0x018c, B:79:0x015c, B:67:0x0132, B:77:0x0155, B:68:0x0137, B:72:0x0144, B:71:0x013f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r23v5 boolean) = (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v6 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean), (r23v1 boolean) binds: [B:51:0x00f7, B:103:0x01b2, B:89:0x0180, B:95:0x0196, B:90:0x0184, B:94:0x0190, B:93:0x018c, B:79:0x015c, B:67:0x0132, B:77:0x0155, B:68:0x0137, B:72:0x0144, B:71:0x013f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v7 boolean) = (r24v2 boolean), (r24v9 boolean), (r24v13 boolean), (r24v13 boolean), (r24v13 boolean), (r24v13 boolean), (r24v13 boolean), (r24v15 boolean), (r24v16 boolean), (r24v16 boolean), (r24v16 boolean), (r24v16 boolean), (r24v16 boolean) binds: [B:51:0x00f7, B:103:0x01b2, B:89:0x0180, B:95:0x0196, B:90:0x0184, B:94:0x0190, B:93:0x018c, B:79:0x015c, B:67:0x0132, B:77:0x0155, B:68:0x0137, B:72:0x0144, B:71:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.k65
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.e35 d(int r27, defpackage.e45 r28, java.util.Map<defpackage.s25, ?> r29) throws defpackage.a35, defpackage.v25, defpackage.r25 {
        /*
        // Method dump skipped, instructions count: 796
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v55.d(int, e45, java.util.Map):e35");
    }
}
