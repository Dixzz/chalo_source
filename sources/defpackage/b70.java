package defpackage;

import android.text.TextUtils;
import defpackage.n00;
import defpackage.yj1;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* renamed from: b70  reason: default package */
/* compiled from: GZipJsonObjectRequestWithHeaders */
public class b70 extends ge1<a70> {
    public int A;

    /* renamed from: b70$a */
    /* compiled from: GZipJsonObjectRequestWithHeaders */
    public class a implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f389a;
        public final /* synthetic */ n00.z0 b;

        public a(String str, n00.z0 z0Var) {
            this.f389a = str;
            this.b = z0Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f389a, ed1);
            }
            this.b.a(dk1);
        }
    }

    public b70(String str, String str2, yj1.b<a70> bVar, n00.z0 z0Var, HashMap<String, String> hashMap) {
        super(0, str, null, bVar, new a(str, z0Var), hashMap);
    }

    @Override // defpackage.ge1, defpackage.wj1
    public yj1 A(tj1 tj1) {
        String str = tj1.c.get("Content-Encoding");
        try {
            String str2 = "";
            if (tj1.b != null) {
                InputStream byteArrayInputStream = new ByteArrayInputStream(tj1.b);
                if (str != null && str.contains("gzip")) {
                    byteArrayInputStream = new GZIPInputStream(byteArrayInputStream);
                }
                InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = str2 + readLine;
                }
                inputStreamReader.close();
                bufferedReader.close();
                byteArrayInputStream.close();
            }
            this.A = tj1.f3365a;
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("data", new JSONObject(str2));
            }
            jSONObject.put("headers", new JSONObject(tj1.c));
            jSONObject.put("statusCode", this.A);
            return new yj1(new a70(jSONObject.toString()), E(tj1));
        } catch (Exception e) {
            return new yj1(new vj1(e));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ge1
    public a70 D(String str) throws Exception {
        return new a70(str);
    }
}
