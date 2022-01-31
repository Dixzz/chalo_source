package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.mpmetrics.InAppNotification;
import defpackage.qd5;
import defpackage.ud5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: dc5  reason: default package */
/* compiled from: DecideChecker */
public class dc5 {
    public static final JSONArray f = new JSONArray();

    /* renamed from: a  reason: collision with root package name */
    public final jc5 f820a;
    public final Context b;
    public final Map<String, ec5> c = new HashMap();
    public final qd5 d;
    public final ed5 e;

    /* renamed from: dc5$a */
    /* compiled from: DecideChecker */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<InAppNotification> f821a = new ArrayList();
        public final List<InAppNotification> b = new ArrayList();
        public JSONArray c;
        public JSONArray d;
        public boolean e;

        public a() {
            JSONArray jSONArray = dc5.f;
            this.c = jSONArray;
            this.d = jSONArray;
            this.e = false;
        }
    }

    /* renamed from: dc5$b */
    /* compiled from: DecideChecker */
    public static class b extends Exception {
        public b(String str, JSONException jSONException) {
            super(str, jSONException);
        }
    }

    public dc5(Context context, jc5 jc5) {
        this.b = context;
        this.f820a = jc5;
        this.d = new qd5(context, "DecideChecker");
        this.e = ed5.a(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[SYNTHETIC, Splitter:B:25:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.dc5.a a(java.lang.String r8, java.lang.String r9, defpackage.ud5 r10) throws defpackage.ud5.a, defpackage.dc5.b {
        /*
        // Method dump skipped, instructions count: 425
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dc5.a(java.lang.String, java.lang.String, ud5):dc5$a");
    }

    public void b(String str, ud5 ud5) throws ud5.a {
        String str2;
        ec5 ec5 = this.c.get(str);
        if (ec5 != null) {
            synchronized (ec5) {
                str2 = ec5.f956a;
            }
            try {
                a a2 = a(ec5.b, str2, ud5);
                if (a2 != null) {
                    ec5.b(a2.f821a, a2.b, a2.c, a2.d, a2.e);
                }
            } catch (b e2) {
                e2.getMessage();
            }
        }
    }

    public final void c(Iterator<InAppNotification> it) throws ud5.a {
        Bitmap bitmap;
        while (it.hasNext()) {
            InAppNotification next = it.next();
            Context context = this.b;
            int i = 0;
            String[] strArr = {InAppNotification.e(next.m, "@2x"), next.m};
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            int i2 = point.x;
            if (next.b() == InAppNotification.b.TAKEOVER && i2 >= 720) {
                strArr = new String[]{InAppNotification.e(next.m, "@4x"), InAppNotification.e(next.m, "@2x"), next.m};
            }
            int length = strArr.length;
            while (true) {
                if (i >= length) {
                    bitmap = null;
                    break;
                }
                try {
                    bitmap = this.d.b(strArr[i]);
                    break;
                } catch (qd5.a unused) {
                    i++;
                }
            }
            if (bitmap == null) {
                it.remove();
            } else {
                next.o = bitmap;
            }
        }
    }
}
