package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.FirebaseApp;
import com.rabbitmq.client.ConnectionFactory;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: t63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class t63 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, r63> f3313a = new n2();
    public static final Map<String, WeakReference<s63>> b = new n2();

    public static boolean a(FirebaseApp firebaseApp) {
        return ((u2) f3313a).containsKey(firebaseApp.getOptions().getApiKey());
    }

    public static String b(String str) {
        r63 r63;
        String str2;
        Map<String, r63> map = f3313a;
        synchronized (map) {
            r63 = (r63) ((u2) map).get(str);
        }
        if (r63 != null) {
            String str3 = r63.f3048a;
            String valueOf = String.valueOf(c(str3, r63.b, str3.contains(ProductDiscountsObject.KEY_DELIMITER)));
            str2 = valueOf.length() != 0 ? "".concat(valueOf) : new String("");
        } else {
            str2 = "https://";
        }
        return String.valueOf(str2).concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    public static String c(String str, int i, boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("http://[");
            sb.append(str);
            sb.append("]:");
            sb.append(i);
            sb.append(ConnectionFactory.DEFAULT_VHOST);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 20);
        sb2.append("http://");
        sb2.append(str);
        sb2.append(ProductDiscountsObject.KEY_DELIMITER);
        sb2.append(i);
        sb2.append(ConnectionFactory.DEFAULT_VHOST);
        return sb2.toString();
    }
}
