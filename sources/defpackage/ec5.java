package defpackage;

import android.content.Context;
import com.mixpanel.android.mpmetrics.InAppNotification;
import defpackage.ac5;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: ec5  reason: default package */
/* compiled from: DecideMessages */
public class ec5 {
    public static final Set<Integer> k = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public String f956a = null;
    public final String b;
    public final Set<Integer> c;
    public final List<InAppNotification> d = new LinkedList();
    public final List<InAppNotification> e;
    public final a f;
    public final fe5 g;
    public JSONArray h;
    public Boolean i;
    public Context j;

    /* renamed from: ec5$a */
    /* compiled from: DecideMessages */
    public interface a {
    }

    public ec5(Context context, String str, a aVar, fe5 fe5, HashSet<Integer> hashSet) {
        this.j = context;
        this.b = str;
        this.f = aVar;
        this.g = fe5;
        this.c = new HashSet(hashSet);
        this.e = new LinkedList();
        this.h = null;
    }

    public synchronized InAppNotification a(ac5.a aVar, boolean z) {
        if (this.e.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            InAppNotification inAppNotification = this.e.get(i2);
            if (inAppNotification.d(aVar)) {
                if (!z) {
                    this.e.remove(i2);
                }
                return inAppNotification;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(java.util.List<com.mixpanel.android.mpmetrics.InAppNotification> r9, java.util.List<com.mixpanel.android.mpmetrics.InAppNotification> r10, org.json.JSONArray r11, org.json.JSONArray r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ec5.b(java.util.List, java.util.List, org.json.JSONArray, org.json.JSONArray, boolean):void");
    }

    public synchronized void c(String str) {
        String str2 = this.f956a;
        if (str2 == null || !str2.equals(str)) {
            this.d.clear();
        }
        this.f956a = str;
    }
}
