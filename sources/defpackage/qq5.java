package defpackage;

import android.net.Uri;
import com.urbanairship.UAirship;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: qq5  reason: default package */
/* compiled from: Request */
public class qq5 {
    public static final uq5<Void> k = new a();

    /* renamed from: a  reason: collision with root package name */
    public Uri f2981a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g = 0;
    public boolean h = false;
    public boolean i = true;
    public final Map<String, String> j = new HashMap();

    /* renamed from: qq5$a */
    /* compiled from: Request */
    public static class a implements uq5<Void> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public /* bridge */ /* synthetic */ Void a(int i, Map map, String str) throws Exception {
            return null;
        }
    }

    public tq5<Void> a() throws rq5 {
        return b(k);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x015d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> defpackage.tq5<T> b(defpackage.uq5<T> r12) throws defpackage.rq5 {
        /*
        // Method dump skipped, instructions count: 378
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qq5.b(uq5):tq5");
    }

    public final String c(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    yj5.e(e2, "Failed to close streams", new Object[0]);
                }
                throw th;
            }
        }
        bufferedReader.close();
        try {
            inputStream.close();
            bufferedReader.close();
        } catch (Exception e3) {
            yj5.e(e3, "Failed to close streams", new Object[0]);
        }
        return sb.toString();
    }

    public qq5 d() {
        this.j.put("Accept", "application/vnd.urbanairship+json; version=3;");
        return this;
    }

    public qq5 e(kq5 kq5) {
        int a2 = kq5.a();
        String str = a2 != 1 ? a2 != 2 ? "unknown" : "android" : "amazon";
        Locale locale = Locale.ROOT;
        Object obj = UAirship.t;
        String format = String.format(locale, "(UrbanAirshipLib-%s/%s; %s)", str, "14.6.0", kq5.b.f711a);
        this.j.put("X-UA-App-Key", kq5.b.f711a);
        this.j.put("User-Agent", format);
        return this;
    }

    public qq5 f(cu5 cu5) {
        this.e = cu5.b().toString();
        this.f = "application/json";
        return this;
    }
}
