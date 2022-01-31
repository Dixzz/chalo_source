package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: be5  reason: default package */
/* compiled from: Pathfinder */
public class be5 {

    /* renamed from: a  reason: collision with root package name */
    public final b f416a = new b();

    /* renamed from: be5$a */
    /* compiled from: Pathfinder */
    public interface a {
        void a(View view);
    }

    /* renamed from: be5$b */
    /* compiled from: Pathfinder */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f417a = new int[256];
        public int b = 0;
    }

    /* renamed from: be5$c */
    /* compiled from: Pathfinder */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f418a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;
        public final String f;

        public c(int i, String str, int i2, int i3, String str2, String str3) {
            this.f418a = i;
            this.b = str;
            this.c = i2;
            this.d = i3;
            this.e = str2;
            this.f = str3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f418a == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                String str = this.b;
                if (str != null) {
                    jSONObject.put("view_class", str);
                }
                int i = this.c;
                if (i > -1) {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
                }
                int i2 = this.d;
                if (i2 > -1) {
                    jSONObject.put("id", i2);
                }
                String str2 = this.e;
                if (str2 != null) {
                    jSONObject.put("contentDescription", str2);
                }
                String str3 = this.f;
                if (str3 != null) {
                    jSONObject.put("tag", str3);
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                throw new RuntimeException("Can't serialize PathElement to String", e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r1 == false) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(defpackage.be5.c r8, android.view.View r9, int r10) {
        /*
        // Method dump skipped, instructions count: 149
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.be5.a(be5$c, android.view.View, int):android.view.View");
    }

    public final void b(View view, List<c> list, a aVar) {
        if (list.isEmpty()) {
            aVar.a(view);
        } else if (view instanceof ViewGroup) {
            b bVar = this.f416a;
            if (!(bVar.f417a.length == bVar.b)) {
                ViewGroup viewGroup = (ViewGroup) view;
                c cVar = list.get(0);
                List<c> subList = list.subList(1, list.size());
                int childCount = viewGroup.getChildCount();
                b bVar2 = this.f416a;
                int i = bVar2.b;
                bVar2.b = i + 1;
                bVar2.f417a[i] = 0;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View a2 = a(cVar, viewGroup.getChildAt(i2), i);
                    if (a2 != null) {
                        b(a2, subList, aVar);
                    }
                    int i3 = cVar.c;
                    if (i3 >= 0 && this.f416a.f417a[i] > i3) {
                        break;
                    }
                }
                b bVar3 = this.f416a;
                int i4 = bVar3.b - 1;
                bVar3.b = i4;
                if (i4 < 0) {
                    throw new ArrayIndexOutOfBoundsException(bVar3.b);
                }
            }
        }
    }

    public void c(View view, List<c> list, a aVar) {
        if (!list.isEmpty()) {
            b bVar = this.f416a;
            if (!(bVar.f417a.length == bVar.b)) {
                List<c> subList = list.subList(1, list.size());
                b bVar2 = this.f416a;
                int i = bVar2.b;
                bVar2.b = i + 1;
                bVar2.f417a[i] = 0;
                View a2 = a(list.get(0), view, i);
                b bVar3 = this.f416a;
                int i2 = bVar3.b - 1;
                bVar3.b = i2;
                if (i2 < 0) {
                    throw new ArrayIndexOutOfBoundsException(bVar3.b);
                } else if (a2 != null) {
                    b(a2, subList, aVar);
                }
            }
        }
    }
}
