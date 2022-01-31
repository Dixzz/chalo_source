package defpackage;

import android.net.Uri;
import app.zophop.models.Stop;
import defpackage.k30;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: l00  reason: default package */
/* compiled from: AutocompleteFeature */
public class l00 {

    /* renamed from: a  reason: collision with root package name */
    public final i30 f2144a;

    /* renamed from: l00$a */
    /* compiled from: AutocompleteFeature */
    public class a implements k30.a<Stop> {
        public a(l00 l00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.k30.a
        public String a(Stop stop) {
            return stop.getName();
        }
    }

    public l00(i30 i30) {
        this.f2144a = i30;
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Lapp/zophop/models/TransitMode;Z)Ljava/util/List<Lapp/zophop/models/RouteInfo;>; */
    public List a(String str, Map map, boolean z) {
        if (z || !this.f2144a.j()) {
            ki1 ki1 = new ki1();
            try {
                Uri.Builder b = ki1.b(str);
                if (map != null) {
                    for (String str2 : map.keySet()) {
                        b.appendQueryParameter(str2, (String) map.get(str2));
                    }
                }
                b.build().toString();
                return new rv().d(new JSONArray(ki1.a(b.build().toString())));
            } catch (Exception unused) {
                return new ArrayList();
            }
        } else {
            return new k30().a(str, xt.f3961a.A().f, new m00(this));
        }
    }

    public List<Stop> b(String str, List<Stop> list) {
        return new k30().a(str, list, new a(this));
    }
}
