package defpackage;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: nv4  reason: default package */
public final class nv4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2609a;

    public nv4(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        this.f2609a = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    public static String c(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException unused) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    "Unable to format ".concat(valueOf);
                } else {
                    new String("Unable to format ");
                }
                String join = TextUtils.join(", ", objArr);
                str2 = hj1.c0(new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length()), str2, " [", join, "]");
            }
        }
        return hj1.b0(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()), str, " : ", str2);
    }

    public final void a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            c(this.f2609a, str, objArr);
        }
    }

    public final int b(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", c(this.f2609a, str, objArr));
        }
        return 0;
    }
}
