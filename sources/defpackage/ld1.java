package defpackage;

/* renamed from: ld1  reason: default package */
/* compiled from: AutoCompleteHelper */
public abstract class ld1<T> {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r7) throws java.lang.Exception {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x004d, IOException -> 0x0046, all -> 0x003f }
            r2.<init>(r7)     // Catch:{ MalformedURLException -> 0x004d, IOException -> 0x0046, all -> 0x003f }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ MalformedURLException -> 0x004d, IOException -> 0x0046, all -> 0x003f }
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ MalformedURLException -> 0x004d, IOException -> 0x0046, all -> 0x003f }
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ MalformedURLException -> 0x004d, IOException -> 0x0046, all -> 0x003f }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ MalformedURLException -> 0x004d, IOException -> 0x0046, all -> 0x003f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x003d, IOException -> 0x003b, all -> 0x0038 }
            java.io.InputStream r3 = r7.getInputStream()     // Catch:{ MalformedURLException -> 0x003d, IOException -> 0x003b, all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x003d, IOException -> 0x003b, all -> 0x0038 }
            r3 = 1024(0x400, float:1.435E-42)
            char[] r3 = new char[r3]     // Catch:{ MalformedURLException -> 0x003d, IOException -> 0x003b, all -> 0x0038 }
        L_0x0024:
            int r4 = r2.read(r3)     // Catch:{ MalformedURLException -> 0x003d, IOException -> 0x003b, all -> 0x0038 }
            r5 = -1
            if (r4 == r5) goto L_0x0030
            r5 = 0
            r0.append(r3, r5, r4)     // Catch:{ MalformedURLException -> 0x003d, IOException -> 0x003b, all -> 0x0038 }
            goto L_0x0024
        L_0x0030:
            r7.disconnect()
            java.lang.String r7 = r0.toString()
            return r7
        L_0x0038:
            r0 = move-exception
            r1 = r7
            goto L_0x0040
        L_0x003b:
            goto L_0x0047
        L_0x003d:
            goto L_0x004e
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.disconnect()
        L_0x0045:
            throw r0
        L_0x0046:
            r7 = r1
        L_0x0047:
            if (r7 == 0) goto L_0x004c
            r7.disconnect()
        L_0x004c:
            return r1
        L_0x004d:
            r7 = r1
        L_0x004e:
            if (r7 == 0) goto L_0x0053
            r7.disconnect()
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ld1.a(java.lang.String):java.lang.String");
    }
}
