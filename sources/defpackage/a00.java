package defpackage;

import android.text.TextUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* renamed from: a00  reason: default package */
/* compiled from: CrashlyticsReporter.kt */
public final class a00 implements c00 {
    @Override // defpackage.c00
    public void a(String str, String str2) {
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append((Object) str);
        sb.append(':');
        sb.append((Object) str2);
        instance.log(sb.toString());
    }

    @Override // defpackage.c00
    public void b(Throwable th) {
        if (th != null) {
            FirebaseCrashlytics.getInstance().recordException(th);
        }
    }

    @Override // defpackage.c00
    public void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            n86.c(str);
            n86.c(str2);
            instance.setCustomKey(str, str2);
        }
    }
}
