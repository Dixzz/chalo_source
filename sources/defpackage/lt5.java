package defpackage;

import android.content.Context;
import com.urbanairship.R;
import com.urbanairship.json.JsonValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: lt5  reason: default package */
/* compiled from: JavaScriptEnvironment */
public class lt5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f2268a;

    /* renamed from: lt5$b */
    /* compiled from: JavaScriptEnvironment */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f2269a = new ArrayList();

        public b(a aVar) {
        }

        public b a(String str, cu5 cu5) {
            this.f2269a.add(String.format(Locale.ROOT, "_UAirship.%s = function(){return %s;};", str, (cu5 == null ? JsonValue.g : cu5.b()).toString()));
            return this;
        }

        public b b(String str, String str2) {
            a(str, JsonValue.x(str2));
            return this;
        }
    }

    public lt5(b bVar, a aVar) {
        this.f2268a = new ArrayList(bVar.f2269a);
    }

    public static String a(Context context) throws IOException {
        InputStream openRawResource = context.getResources().openRawResource(R.raw.ua_native_bridge);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            try {
                openRawResource.close();
                byteArrayOutputStream.close();
            } catch (Exception e) {
                yj5.b(e, "Failed to close streams", new Object[0]);
            }
            return byteArrayOutputStream2;
        } catch (Throwable th) {
            try {
                openRawResource.close();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                yj5.b(e2, "Failed to close streams", new Object[0]);
            }
            throw th;
        }
    }
}
