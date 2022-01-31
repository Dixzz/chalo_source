package defpackage;

import android.app.Activity;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: k63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class k63 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, j63> f2030a = new n2();

    public static void a() {
        ((u2) f2030a).clear();
    }

    public static boolean b(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, j63> map = f2030a;
        if (((u2) map).e(str) >= 0) {
            j63 j63 = (j63) ((u2) map).getOrDefault(str, null);
            if (System.currentTimeMillis() - j63.b < 120000) {
                d63 d63 = j63.f1884a;
                if (d63 != null) {
                    d63.f(onVerificationStateChangedCallbacks, activity, executor, str);
                }
                return true;
            }
            d(str, null);
            return false;
        }
        d(str, null);
        return false;
    }

    public static void d(String str, d63 d63) {
        ((u2) f2030a).put(str, new j63(d63, System.currentTimeMillis()));
    }
}
