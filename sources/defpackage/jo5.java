package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.urbanairship.automation.limits.storage.FrequencyLimitDatabase;
import defpackage.q5;
import defpackage.wl;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* renamed from: jo5  reason: default package */
/* compiled from: FrequencyLimitManager */
public class jo5 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<ko5, List<no5>> f1962a = new WeakHashMap();
    public final List<no5> b = new ArrayList();
    public final Object c = new Object();
    public final lo5 d;
    public final hy5 e;
    public final Executor f;

    /* renamed from: jo5$a */
    /* compiled from: FrequencyLimitManager */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ArrayList arrayList;
            jo5 jo5 = jo5.this;
            synchronized (jo5.c) {
                arrayList = new ArrayList(jo5.b);
                jo5.b.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                no5 no5 = (no5) it.next();
                try {
                    mo5 mo5 = (mo5) jo5.d;
                    mo5.f2419a.assertNotSuspendingTransaction();
                    mo5.f2419a.beginTransaction();
                    try {
                        mo5.c.insert(no5);
                        mo5.f2419a.setTransactionSuccessful();
                    } finally {
                        mo5.f2419a.endTransaction();
                    }
                } catch (SQLiteException e) {
                    yj5.f4059a.a(2, e, null, null);
                }
            }
        }
    }

    public jo5(Context context, kq5 kq5) {
        String a0 = hj1.a0(new StringBuilder(), kq5.b.f711a, "_frequency_limits");
        Object obj = q5.f2896a;
        wl.a C = h.C(context, FrequencyLimitDatabase.class, new File(q5.c.c(context), a0).getAbsolutePath());
        C.c();
        lo5 a2 = ((FrequencyLimitDatabase) C.b()).a();
        hy5 hy5 = hy5.f1445a;
        Executor a3 = pj5.a();
        this.d = a2;
        this.e = hy5;
        this.f = a3;
    }

    /* JADX INFO: finally extract failed */
    public static Collection a(jo5 jo5, Collection collection) {
        Objects.requireNonNull(jo5);
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        mo5 mo5 = (mo5) jo5.d;
        Objects.requireNonNull(mo5);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM constraints WHERE (constraintId IN (");
        int size = collection.size();
        im.a(sb, size);
        sb.append("))");
        yl e2 = yl.e(sb.toString(), size + 0);
        Iterator it = collection.iterator();
        int i = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                e2.E0(i);
            } else {
                e2.z(i, str);
            }
            i++;
        }
        mo5.f2419a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(mo5.f2419a, e2, false, null);
        try {
            int L = h.L(b2, "id");
            int L2 = h.L(b2, "constraintId");
            int L3 = h.L(b2, "count");
            int L4 = h.L(b2, "range");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                ko5 ko5 = new ko5();
                ko5.f2094a = b2.getInt(L);
                ko5.b = b2.getString(L2);
                ko5.c = b2.getInt(L3);
                ko5.d = b2.getLong(L4);
                arrayList.add(ko5);
            }
            b2.close();
            e2.f();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ko5 ko52 = (ko5) it2.next();
                lo5 lo5 = jo5.d;
                String str2 = ko52.b;
                mo5 mo52 = (mo5) lo5;
                Objects.requireNonNull(mo52);
                yl e3 = yl.e("SELECT * FROM occurrences WHERE parentConstraintId = ? ORDER BY timeStamp ASC", 1);
                if (str2 == null) {
                    e3.E0(1);
                } else {
                    e3.z(1, str2);
                }
                mo52.f2419a.assertNotSuspendingTransaction();
                Cursor b3 = hm.b(mo52.f2419a, e3, false, null);
                try {
                    int L5 = h.L(b3, "id");
                    int L6 = h.L(b3, "parentConstraintId");
                    int L7 = h.L(b3, "timeStamp");
                    ArrayList arrayList2 = new ArrayList(b3.getCount());
                    while (b3.moveToNext()) {
                        no5 no5 = new no5();
                        no5.f2584a = b3.getInt(L5);
                        no5.b = b3.getString(L6);
                        no5.c = b3.getLong(L7);
                        arrayList2.add(no5);
                    }
                    b3.close();
                    e3.f();
                    synchronized (jo5.c) {
                        for (no5 no52 : jo5.b) {
                            if (no52.b.equals(ko52.b)) {
                                arrayList2.add(no52);
                            }
                        }
                        jo5.f1962a.put(ko52, arrayList2);
                    }
                } catch (Throwable th) {
                    b3.close();
                    e3.f();
                    throw th;
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            b2.close();
            e2.f();
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.util.Collection<defpackage.ko5> r10) {
        /*
            r9 = this;
            boolean r0 = r10.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Object r0 = r9.c
            monitor-enter(r0)
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0057 }
        L_0x000f:
            boolean r2 = r10.hasNext()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x0055
            java.lang.Object r2 = r10.next()     // Catch:{ all -> 0x0057 }
            ko5 r2 = (defpackage.ko5) r2     // Catch:{ all -> 0x0057 }
            java.util.Map<ko5, java.util.List<no5>> r3 = r9.f1962a     // Catch:{ all -> 0x0057 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0057 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0057 }
            r4 = 1
            if (r3 == 0) goto L_0x0050
            int r5 = r3.size()     // Catch:{ all -> 0x0057 }
            int r6 = r2.c     // Catch:{ all -> 0x0057 }
            if (r5 >= r6) goto L_0x002f
            goto L_0x0050
        L_0x002f:
            hy5 r5 = r9.e     // Catch:{ all -> 0x0057 }
            java.util.Objects.requireNonNull(r5)     // Catch:{ all -> 0x0057 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0057 }
            int r7 = r3.size()     // Catch:{ all -> 0x0057 }
            int r8 = r2.c     // Catch:{ all -> 0x0057 }
            int r7 = r7 - r8
            java.lang.Object r3 = r3.get(r7)     // Catch:{ all -> 0x0057 }
            no5 r3 = (defpackage.no5) r3     // Catch:{ all -> 0x0057 }
            long r7 = r3.c     // Catch:{ all -> 0x0057 }
            long r5 = r5 - r7
            long r2 = r2.d     // Catch:{ all -> 0x0057 }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 > 0) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return r4
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return r1
        L_0x0057:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jo5.b(java.util.Collection):boolean");
    }

    public final void c(Set<String> set) {
        if (!set.isEmpty()) {
            Objects.requireNonNull(this.e);
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : set) {
                no5 no5 = new no5();
                no5.b = str;
                no5.c = currentTimeMillis;
                this.b.add(no5);
                for (Map.Entry<ko5, List<no5>> entry : this.f1962a.entrySet()) {
                    ko5 key = entry.getKey();
                    if (key != null && str.equals(key.b)) {
                        entry.getValue().add(no5);
                    }
                }
            }
            this.f.execute(new a());
        }
    }
}
