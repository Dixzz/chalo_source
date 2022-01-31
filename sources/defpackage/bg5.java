package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: bg5  reason: default package */
/* compiled from: ServerLogs */
public class bg5 {

    /* renamed from: a  reason: collision with root package name */
    public Context f429a;
    public a b = new a();

    /* renamed from: bg5$a */
    /* compiled from: ServerLogs */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f430a = new ArrayList<>();
    }

    public bg5(Context context, boolean z) {
        new JSONArray();
        this.f429a = context;
        context.getSharedPreferences("trill_sdk_data_3stream", 0);
    }

    public void a(String str, String str2) {
        ArrayList<String> arrayList = this.b.f430a;
        arrayList.add(String.valueOf(System.currentTimeMillis()) + " : " + str + " : " + str2);
    }

    public void b() {
        a aVar = this.b;
        Objects.requireNonNull(aVar);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < aVar.f430a.size(); i++) {
            jSONArray.put(aVar.f430a.get(i));
        }
        aVar.f430a = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                jSONArray.getString(i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
