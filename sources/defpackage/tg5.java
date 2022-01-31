package defpackage;

import android.content.Context;
import android.content.Intent;
import com.razorpay.BaseConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: tg5  reason: default package */
/* compiled from: ShareProfileHelper */
public class tg5 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<b> f3352a;

    /* renamed from: tg5$b */
    /* compiled from: ShareProfileHelper */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Set<String> f3353a;

        static {
            HashSet hashSet = new HashSet(2);
            hashSet.add("0ac1169ae6cead75264c725febd8e8d941f25e31");
            hashSet.add("8a03e08e354a73ac49509c8b708fbe15aee2fb2a");
            f3353a = hashSet;
        }

        public abstract String a();
    }

    /* renamed from: tg5$c */
    /* compiled from: ShareProfileHelper */
    public static class c extends b {
        public c(a aVar) {
        }

        @Override // defpackage.tg5.b
        public String a() {
            return BaseConstants.TRUE_CALLER_PKG;
        }
    }

    /* renamed from: tg5$d */
    /* compiled from: ShareProfileHelper */
    public static class d extends b {
        public d(a aVar) {
        }

        @Override // defpackage.tg5.b
        public String a() {
            return "com.truecaller.debug";
        }
    }

    /* renamed from: tg5$e */
    /* compiled from: ShareProfileHelper */
    public static class e extends b {
        public e(a aVar) {
        }

        @Override // defpackage.tg5.b
        public String a() {
            return "com.truecaller.messenger";
        }
    }

    /* renamed from: tg5$f */
    /* compiled from: ShareProfileHelper */
    public static class f extends b {
        public f(a aVar) {
        }

        @Override // defpackage.tg5.b
        public String a() {
            return "com.truecaller.messenger.debug";
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f3352a = arrayList;
        arrayList.add(new c(null));
        arrayList.add(new e(null));
        arrayList.add(new d(null));
        arrayList.add(new f(null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        r14.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tg5.a(android.content.Context, java.lang.String):android.content.Intent");
    }

    public static Intent b(Context context, wg5 wg5) {
        if (wg5 != null) {
            Intent intent = null;
            if (wg5.a(8)) {
                intent = a(context, "com.truecaller.android.sdk.intent.action.v2.SHARE_PROFILE");
            } else if (wg5.a(128)) {
                intent = a(context, "com.truecaller.android.sdk.intent.action.v3.SHARE_PROFILE");
            }
            if (intent != null) {
                return intent;
            }
        }
        return a(context, "com.truecaller.android.sdk.intent.action.v1.SHARE_PROFILE");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tg5.c(android.content.Context):boolean");
    }
}
