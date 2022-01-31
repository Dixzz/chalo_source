package defpackage;

import android.util.Log;
import com.google.firebase.appindexing.Indexable;
import java.util.List;

/* renamed from: r53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class r53 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3045a;

    public r53(String str) {
        int i;
        try {
            List<String> b = un2.a("[.-]").b(str);
            if (b.size() == 1) {
                i = Integer.parseInt(str);
            } else {
                if (b.size() >= 3) {
                    i = Integer.parseInt(b.get(2)) + (Integer.parseInt(b.get(1)) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL) + (Integer.parseInt(b.get(0)) * 1000000);
                }
                i = -1;
            }
        } catch (IllegalArgumentException e) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                String.format("Version code parsing failed for: %s with exception %s.", str, e);
            }
        }
        this.f3045a = i;
    }

    public static r53 b() {
        return new r53(c());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0 A[SYNTHETIC, Splitter:B:46:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104 A[SYNTHETIC, Splitter:B:65:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c() {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r53.c():java.lang.String");
    }

    public final String a() {
        return String.format("X%s", Integer.toString(this.f3045a));
    }
}
