package defpackage;

import java.util.regex.Pattern;

/* renamed from: fb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class fb2 {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0061 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.RecentlyNonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(@androidx.annotation.RecentlyNonNull java.net.URI r5, @androidx.annotation.RecentlyNonNull java.lang.String r6) {
        /*
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r5 = r5.getRawQuery()
            if (r5 == 0) goto L_0x0061
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x0061
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Scanner r1 = new java.util.Scanner
            r1.<init>(r5)
            java.lang.String r5 = "&"
            r1.useDelimiter(r5)
        L_0x001f:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0061
            java.lang.String r5 = r1.next()
            java.lang.String r2 = "="
            java.lang.String[] r5 = r5.split(r2)
            int r2 = r5.length
            if (r2 == 0) goto L_0x0059
            r3 = 2
            if (r2 > r3) goto L_0x0059
            r4 = 0
            r4 = r5[r4]
            java.lang.String r4 = java.net.URLDecoder.decode(r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x0052 }
            if (r2 != r3) goto L_0x004d
            r2 = 1
            r5 = r5[r2]
            java.lang.String r5 = java.net.URLDecoder.decode(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0046 }
            goto L_0x004e
        L_0x0046:
            r5 = move-exception
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>(r5)
            throw r6
        L_0x004d:
            r5 = 0
        L_0x004e:
            r0.put(r4, r5)
            goto L_0x001f
        L_0x0052:
            r5 = move-exception
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>(r5)
            throw r6
        L_0x0059:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "bad parameter"
            r5.<init>(r6)
            throw r5
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fb2.a(java.net.URI, java.lang.String):java.util.Map");
    }
}
