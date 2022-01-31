package defpackage;

import android.content.Context;
import com.rabbitmq.client.ConnectionFactory;
import java.net.URLConnection;
import java.util.Objects;

/* renamed from: t53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class t53 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3310a;
    public g63 b;
    public final String c;
    public boolean d = false;
    public String e;

    public t53(Context context, String str) {
        Objects.requireNonNull(context, "null reference");
        this.f3310a = context.getApplicationContext();
        this.c = String.format("Android/%s/%s", "Fallback", str);
    }

    public final void a(URLConnection uRLConnection) {
        String str;
        if (this.d) {
            String str2 = this.c;
            str = hj1.b0(new StringBuilder(String.valueOf(str2).length() + 19), str2, ConnectionFactory.DEFAULT_VHOST, "FirebaseUI-Android");
        } else {
            String str3 = this.c;
            str = hj1.b0(new StringBuilder(String.valueOf(str3).length() + 21), str3, ConnectionFactory.DEFAULT_VHOST, "FirebaseCore-Android");
        }
        if (this.b == null) {
            Context context = this.f3310a;
            this.b = new g63(context, context.getPackageName());
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.b.f1219a);
        uRLConnection.setRequestProperty("X-Android-Cert", this.b.b);
        uRLConnection.setRequestProperty("Accept-Language", gj1.S0());
        uRLConnection.setRequestProperty("X-Client-Version", str);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.e);
        this.e = null;
    }
}
