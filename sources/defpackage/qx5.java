package defpackage;

import android.util.SparseArray;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.urbanairship.UAirship;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import server.zophop.Constants;

/* renamed from: qx5  reason: default package */
/* compiled from: ModuleAdapter */
public class qx5 {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<Set<oj5>> f3003a = null;

    public final Collection<? extends oj5> a(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1693017210:
                if (str.equals(Constants.PRODUCTION_ANALYTICS)) {
                    c = 0;
                    break;
                }
                break;
            case -1071151692:
                if (str.equals("in_app_v2")) {
                    c = 1;
                    break;
                }
                break;
            case -280467183:
                if (str.equals("named_user")) {
                    c = 2;
                    break;
                }
                break;
            case 3052376:
                if (str.equals("chat")) {
                    c = 3;
                    break;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = 4;
                    break;
                }
                break;
            case 344200471:
                if (str.equals("automation")) {
                    c = 5;
                    break;
                }
                break;
            case 536871821:
                if (str.equals("message_center")) {
                    c = 6;
                    break;
                }
                break;
            case 738950403:
                if (str.equals("channel")) {
                    c = 7;
                    break;
                }
                break;
            case 1901043637:
                if (str.equals(FirebaseAnalytics.Param.LOCATION)) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return b(1);
            case 1:
                return b(3);
            case 2:
                return b(5);
            case 3:
                return b(8);
            case 4:
                return b(0);
            case 5:
                return b(4);
            case 6:
                return b(2);
            case 7:
                return b(7);
            case '\b':
                return b(6);
            default:
                yj5.h("Unable to find module: %s", str);
                return Collections.emptyList();
        }
    }

    public final Set<oj5> b(int i) {
        if (this.f3003a == null) {
            List<oj5> list = UAirship.l().c;
            SparseArray<Set<oj5>> sparseArray = new SparseArray<>();
            for (oj5 oj5 : list) {
                Set<oj5> set = sparseArray.get(oj5.a());
                if (set == null) {
                    set = new HashSet<>();
                    sparseArray.put(oj5.a(), set);
                }
                set.add(oj5);
            }
            this.f3003a = sparseArray;
        }
        return this.f3003a.get(i, Collections.emptySet());
    }

    public void c(String str, zt5 zt5) {
        for (oj5 oj5 : a(str)) {
            if (oj5.c()) {
                oj5.f(zt5);
            }
        }
    }

    public void d(String str, boolean z) {
        for (oj5 oj5 : a(str)) {
            if (oj5.c() != z) {
                oj5.f2698a.k(oj5.b, z);
            }
        }
    }
}
