package defpackage;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import defpackage.je5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: wd5  reason: default package */
/* compiled from: DynamicEventTracker */
public class wd5 implements je5.i {

    /* renamed from: a  reason: collision with root package name */
    public final nc5 f3762a;
    public final Handler b;
    public final Runnable c = new b(null);
    public final Map<c, d> d = new HashMap();

    /* renamed from: wd5$b */
    /* compiled from: DynamicEventTracker */
    public final class b implements Runnable {
        public b(a aVar) {
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (wd5.this.d) {
                Iterator<Map.Entry<c, d>> it = wd5.this.d.entrySet().iterator();
                while (it.hasNext()) {
                    d value = it.next().getValue();
                    if (currentTimeMillis - value.f3764a > 1000) {
                        wd5.this.f3762a.r(value.b, value.c);
                        it.remove();
                    }
                }
                if (!wd5.this.d.isEmpty()) {
                    wd5.this.b.postDelayed(this, 500);
                }
            }
        }
    }

    /* renamed from: wd5$c */
    /* compiled from: DynamicEventTracker */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f3763a;

        public c(View view, String str) {
            this.f3763a = view.hashCode() ^ str.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c) || this.f3763a != obj.hashCode()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f3763a;
        }
    }

    /* renamed from: wd5$d */
    /* compiled from: DynamicEventTracker */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f3764a;
        public final String b;
        public final JSONObject c;

        public d(String str, JSONObject jSONObject, long j) {
            this.b = str;
            this.c = jSONObject;
            this.f3764a = j;
        }
    }

    public wd5(nc5 nc5, Handler handler) {
        this.f3762a = nc5;
        this.b = handler;
    }

    public static String a(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount && sb.length() < 128; i++) {
                String a2 = a(viewGroup.getChildAt(i));
                if (a2 != null && a2.length() > 0) {
                    if (z) {
                        sb.append(", ");
                    }
                    sb.append(a2);
                    z = true;
                }
            }
            if (sb.length() > 128) {
                return sb.substring(0, 128);
            }
            if (z) {
                return sb.toString();
            }
            return null;
        }
    }
}
