package defpackage;

import defpackage.jj1;
import defpackage.yj1;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: ge1  reason: default package */
/* compiled from: GZipJsonRequest */
public abstract class ge1<T> extends mk1<T> {
    public int y = -1;
    public Map<String, String> z;

    public ge1(int i, String str, String str2, yj1.b<T> bVar, yj1.a aVar) {
        super(i, str, str2, bVar, aVar);
        this.s = "Volley";
        this.q = new nj1(10000, 1, 1.0f);
    }

    @Override // defpackage.wj1
    public yj1 A(tj1 tj1) {
        String str = tj1.c.get("Content-Encoding");
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(tj1.b);
            if (str != null && str.contains("gzip")) {
                byteArrayInputStream = new GZIPInputStream(byteArrayInputStream);
            }
            InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str2 = str2 + readLine;
                } else {
                    inputStreamReader.close();
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return new yj1(D(str2), E(tj1));
                }
            }
        } catch (Exception e) {
            return new yj1(new vj1(e));
        }
    }

    public abstract T D(String str) throws Exception;

    public jj1.a E(tj1 tj1) {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = tj1.c;
        String str = map.get("Date");
        long Y = str != null ? gj1.Y(str) : 0;
        String str2 = map.get("ETag");
        int i = this.y;
        long j = 3600000 + currentTimeMillis;
        long j2 = currentTimeMillis + (i != -1 ? (long) i : 259200000);
        jj1.a aVar = new jj1.a();
        aVar.f1933a = tj1.b;
        aVar.b = str2;
        aVar.f = j;
        aVar.e = j2;
        aVar.c = Y;
        aVar.g = map;
        return aVar;
    }

    @Override // defpackage.wj1
    public Map m() throws ij1 {
        HashMap m0 = hj1.m0("Accept-Encoding", "gzip");
        Map<String, String> map = this.z;
        if (map != null) {
            m0.putAll(map);
        }
        return m0;
    }

    public ge1(int i, String str, String str2, yj1.b<T> bVar, yj1.a aVar, HashMap<String, String> hashMap) {
        super(i, str, str2, bVar, aVar);
        this.z = hashMap;
        this.s = "Volley";
        this.q = new nj1(10000, 1, 1.0f);
    }
}
