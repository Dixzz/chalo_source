package defpackage;

import com.urbanairship.iam.InAppMessage;
import defpackage.gm5;
import defpackage.wq5;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: hn5  reason: default package */
/* compiled from: InAppMessageScheduleDelegate */
public class hn5 implements nn5<InAppMessage> {

    /* renamed from: a  reason: collision with root package name */
    public jr5 f1399a;

    public hn5(jr5 jr5) {
        this.f1399a = jr5;
    }

    @Override // defpackage.nn5
    public void a(ln5<? extends mn5> ln5) {
        InAppMessage inAppMessage = "in_app_message".equals(ln5.o) ? (InAppMessage) ln5.a() : null;
        jr5 jr5 = this.f1399a;
        jr5.b.execute(new or5(jr5, inAppMessage, ln5.f2243a, ln5.m));
    }

    @Override // defpackage.nn5
    public void b(ln5<? extends mn5> ln5) {
        if ("in_app_message".equals(ln5.o)) {
            jr5 jr5 = this.f1399a;
            jr5.b.execute(new rr5(jr5, ln5.f2243a, (InAppMessage) ln5.a()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.nn5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c(defpackage.ln5<? extends defpackage.mn5> r5) {
        /*
            r4 = this;
            jr5 r0 = r4.f1399a
            java.lang.String r5 = r5.f2243a
            java.util.Map<java.lang.String, wq5> r1 = r0.f1974a
            java.lang.Object r1 = r1.get(r5)
            wq5 r1 = (defpackage.wq5) r1
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x001b
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r2] = r5
            java.lang.String r5 = "Missing adapter for schedule %."
            defpackage.yj5.c(r5, r0)
            r2 = -1
            goto L_0x003b
        L_0x001b:
            android.content.Context r5 = r0.j
            gr5 r0 = r1.c     // Catch:{ Exception -> 0x002f }
            boolean r5 = r0.c(r5)     // Catch:{ Exception -> 0x002f }
            if (r5 == 0) goto L_0x0037
            ar5 r5 = r1.d     // Catch:{ Exception -> 0x002f }
            boolean r5 = r5.a()     // Catch:{ Exception -> 0x002f }
            if (r5 == 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x002f:
            r5 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "AdapterWrapper - Exception during isReady(Activity)."
            defpackage.yj5.e(r5, r1, r0)
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003b
            r2 = 1
        L_0x003b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hn5.c(ln5):int");
    }

    @Override // defpackage.nn5
    public void d(ln5<? extends mn5> ln5) {
        jr5 jr5 = this.f1399a;
        jr5.b.execute(new qr5(jr5, ln5.f2243a));
    }

    @Override // defpackage.nn5
    public void e(ln5<? extends mn5> ln5, gm5.a aVar) {
        jr5 jr5 = this.f1399a;
        String str = ln5.f2243a;
        wq5 wq5 = jr5.f1974a.get(str);
        if (wq5 == null) {
            yj5.c("Missing adapter for schedule %.", str);
            aVar.a();
            return;
        }
        synchronized (jr5.n) {
            jr5.n.put(str, aVar);
        }
        try {
            wq5.b(jr5.j);
            InAppMessage inAppMessage = wq5.b;
            if (inAppMessage.l) {
                jr5.d.i(new br5(str, inAppMessage, wq5.f));
            }
            synchronized (jr5.f) {
                Iterator it = new ArrayList(jr5.f).iterator();
                while (it.hasNext()) {
                    ((ir5) it.next()).a(str, wq5.b);
                }
            }
            yj5.h("Message displayed for schedule %s.", str);
        } catch (wq5.a e) {
            yj5.e(e, "Failed to display in-app message for schedule %s.", str);
            jr5.a(str);
            jr5.b.execute(new mr5(jr5, wq5));
        }
    }

    @Override // defpackage.nn5
    public void f(ln5<? extends mn5> ln5) {
        jr5 jr5 = this.f1399a;
        String str = ln5.f2243a;
        wq5 remove = jr5.f1974a.remove(str);
        if (remove != null) {
            jr5.b.execute(new nr5(jr5, str, remove));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(defpackage.ln5 r11, defpackage.mn5 r12, defpackage.gm5.b r13) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hn5.g(ln5, mn5, gm5$b):void");
    }
}
