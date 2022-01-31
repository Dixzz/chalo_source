package defpackage;

import android.content.Context;
import android.util.Pair;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* renamed from: r00  reason: default package */
/* compiled from: BoostRatingsFeatureImpl */
public class r00 implements e20 {
    public static Set<String> b;

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f3018a;

    public r00(Context context) {
        this.f3018a = new rf1(context, "session_store");
    }

    @Override // defpackage.e20
    public void a() {
        xt.f3961a.l().put("boostRatingsRemindLaterTS", String.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (defpackage.r00.b.contains(r10) != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x015f, code lost:
        if (java.lang.Long.compare(((java.lang.Long) ((android.util.Pair) r3.get(0)).second).longValue() + ((long) (java.lang.Integer.parseInt(defpackage.xt.f3961a.t().f("sessionLastDaysThresholdForBoostRatings")) * 86400000)), ((java.lang.Long) ((android.util.Pair) r3.get(r3.size() - 1)).second).longValue()) >= 0) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r3.contains(r10) != false) goto L_0x0067;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.e20
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(app.zophop.models.City r10, int r11) {
        /*
        // Method dump skipped, instructions count: 423
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r00.b(app.zophop.models.City, int):boolean");
    }

    @Override // defpackage.e20
    public void c() {
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put("boostRatingsAsked", String.valueOf(true));
        t1Var.l().remove("boostRatingsRemindLaterTS");
    }

    @Override // defpackage.e20
    public void d(long j) {
        this.f3018a.j(String.valueOf(j), String.valueOf(System.currentTimeMillis()));
        try {
            Map<String, ?> b2 = this.f3018a.b();
            int parseInt = Integer.parseInt(xt.f3961a.t().f("sessionCountThresholdForBoostRatings"));
            if (b2 != null && b2.size() - parseInt > 0) {
                int size = b2.size() - parseInt;
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, ?> entry : b2.entrySet()) {
                    arrayList.add(new Pair(Long.valueOf(Long.parseLong(entry.getKey())), Long.valueOf(Long.parseLong((String) entry.getValue()))));
                }
                Collections.sort(arrayList, new q00(this));
                for (int i = 0; i < size; i++) {
                    if (i < arrayList.size() && ((Pair) arrayList.get(i)).first != null && this.f3018a.a(((Long) ((Pair) arrayList.get(i)).first).toString())) {
                        this.f3018a.k(((Long) ((Pair) arrayList.get(i)).first).toString());
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
