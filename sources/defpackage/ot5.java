package defpackage;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonValue;
import defpackage.fz5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* renamed from: ot5  reason: default package */
/* compiled from: NativeBridge */
public class ot5 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2729a;
    public final vk5 b;

    /* renamed from: ot5$a */
    /* compiled from: NativeBridge */
    public class a implements pk5 {
        public a() {
        }

        @Override // defpackage.pk5
        public void a(ok5 ok5, rk5 rk5) {
            Objects.requireNonNull(ot5.this);
        }
    }

    /* renamed from: ot5$b */
    /* compiled from: NativeBridge */
    public interface b {
    }

    public ot5(vk5 vk5) {
        Executor a2 = pj5.a();
        this.b = vk5;
        this.f2729a = a2;
    }

    public final Map<String, List<ActionValue>> a(Uri uri, boolean z) {
        JsonValue jsonValue;
        Map<String, List<String>> e = qy5.e(uri);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = (HashMap) e;
        for (String str : hashMap2.keySet()) {
            ArrayList arrayList = new ArrayList();
            if (hashMap2.get(str) == null) {
                yj5.i("No arguments to decode for actionName: %s", str);
                return null;
            }
            List<String> list = (List) hashMap2.get(str);
            if (list != null) {
                for (String str2 : list) {
                    if (z) {
                        try {
                            jsonValue = JsonValue.x(str2);
                        } catch (xt5 e2) {
                            yj5.j(e2, "Invalid json. Unable to create action argument " + str + " with args: " + str2, new Object[0]);
                            return null;
                        }
                    } else {
                        jsonValue = JsonValue.p(str2);
                    }
                    arrayList.add(new ActionValue(jsonValue));
                }
                hashMap.put(str, arrayList);
            }
        }
        if (!hashMap.isEmpty()) {
            return hashMap;
        }
        yj5.i("Error no action names are present in the actions key set", new Object[0]);
        return null;
    }

    @SuppressLint({"LambdaLast"})
    public boolean b(String str, gz5 gz5, uk5 uk5, b bVar) {
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !"uairship".equals(parse.getScheme())) {
            return false;
        }
        yj5.h("Intercepting: %s", str);
        String host = parse.getHost();
        host.hashCode();
        char c = 65535;
        switch (host.hashCode()) {
            case -1507513413:
                if (host.equals("run-actions")) {
                    c = 0;
                    break;
                }
                break;
            case -1316475244:
                if (host.equals("run-action-cb")) {
                    c = 1;
                    break;
                }
                break;
            case -280467183:
                if (host.equals("named_user")) {
                    c = 2;
                    break;
                }
                break;
            case -189575524:
                if (host.equals("run-basic-actions")) {
                    c = 3;
                    break;
                }
                break;
            case 94756344:
                if (host.equals("close")) {
                    c = 4;
                    break;
                }
                break;
            case 104256825:
                if (host.equals("multi")) {
                    c = 5;
                    break;
                }
                break;
        }
        if (c == 0) {
            yj5.f("Running run actions command for URL: %s", str);
            c(uk5, a(parse, false));
        } else if (c == 1) {
            yj5.f("Running run actions command with callback for URL: %s", str);
            List<String> pathSegments = parse.getPathSegments();
            if (pathSegments.size() == 3) {
                yj5.f("Action: %s, Args: %s, Callback: %s", pathSegments.get(0), pathSegments.get(1), pathSegments.get(2));
                String str2 = pathSegments.get(0);
                String str3 = pathSegments.get(1);
                String str4 = pathSegments.get(2);
                try {
                    ActionValue actionValue = new ActionValue(JsonValue.p(str3));
                    Objects.requireNonNull(this.b);
                    tk5 a2 = tk5.a(str2);
                    a2.c = actionValue;
                    a2.f = 3;
                    fz5.a aVar = (fz5.a) uk5;
                    fz5.this.a(a2, aVar.f1192a).c(null, new pt5(this, str2, gz5, str4));
                } catch (xt5 e) {
                    yj5.e(e, "Unable to parse action argument value: %s", str3);
                    d(gz5, "Unable to decode arguments payload", new ActionValue(), str4);
                }
            } else {
                yj5.c("Unable to run action, invalid number of arguments.", new Object[0]);
            }
        } else if (c == 2) {
            yj5.f("Running set Named User command for URL: %s", parse);
            HashMap hashMap = (HashMap) qy5.e(parse);
            if (hashMap.get("id") != null) {
                UAirship.l().o.l((String) ((List) hashMap.get("id")).get(0));
            } else if (((List) hashMap.get("id")).get(0) == null) {
                UAirship.l().o.l(null);
            }
        } else if (c == 3) {
            yj5.f("Running run basic actions command for URL: %s", str);
            c(uk5, a(parse, true));
        } else if (c == 4) {
            yj5.f("Running close command for URL: %s", str);
            fz5.b bVar2 = (fz5.b) bVar;
            fz5 fz5 = fz5.this;
            WebView webView = bVar2.f1193a;
            Objects.requireNonNull(fz5);
            webView.getRootView().dispatchKeyEvent(new KeyEvent(0, 4));
            webView.getRootView().dispatchKeyEvent(new KeyEvent(1, 4));
        } else if (c != 5) {
            fz5.b bVar3 = (fz5.b) bVar;
            fz5.this.e(bVar3.f1193a, parse.getHost(), parse);
        } else {
            for (String str5 : parse.getEncodedQuery().split("&")) {
                b(Uri.decode(str5), gz5, uk5, bVar);
            }
        }
        return true;
    }

    public final void c(uk5 uk5, Map<String, List<ActionValue>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                List<ActionValue> list = map.get(str);
                if (list != null) {
                    for (ActionValue actionValue : list) {
                        Objects.requireNonNull(this.b);
                        tk5 a2 = tk5.a(str);
                        a2.c = actionValue;
                        a2.f = 3;
                        fz5.a aVar = (fz5.a) uk5;
                        fz5.this.a(a2, aVar.f1192a).c(null, new a());
                    }
                }
            }
        }
    }

    public final void d(gz5 gz5, String str, ActionValue actionValue, String str2) {
        String str3;
        String format = String.format("'%s'", str2);
        if (str == null) {
            str3 = AnalyticsConstants.NULL;
        } else {
            str3 = String.format(Locale.US, "new Error(%s)", JSONObject.quote(str));
        }
        String actionValue2 = actionValue.toString();
        String format2 = String.format(Locale.US, "UAirship.finishAction(%s, %s, %s);", str3, actionValue2, format);
        WebView webView = gz5.f1321a.get();
        if (webView != null) {
            webView.evaluateJavascript(format2, null);
        }
    }
}
