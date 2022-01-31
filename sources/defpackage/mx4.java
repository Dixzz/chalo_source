package defpackage;

import android.content.Context;
import android.os.Process;

/* renamed from: mx4  reason: default package */
public final class mx4 {
    static {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        if ("SplitInstallInfoProvider".length() != 0) {
            valueOf.concat("SplitInstallInfoProvider");
        } else {
            new String(valueOf);
        }
    }

    public mx4(Context context) {
        context.getPackageName();
    }
}
