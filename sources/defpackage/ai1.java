package defpackage;

import android.content.Context;
import android.net.Uri;
import app.zophop.room.CityData;
import app.zophop.room.CityDataRepository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ai1  reason: default package */
/* compiled from: FirebaseCallManager */
public class ai1 {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Integer> f166a = new HashMap();
    public static CityDataRepository b;

    /* renamed from: ai1$a */
    /* compiled from: FirebaseCallManager */
    public class a implements ValueEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSnapshot[] f167a;
        public final /* synthetic */ CountDownLatch b;

        public a(DataSnapshot[] dataSnapshotArr, CountDownLatch countDownLatch) {
            this.f167a = dataSnapshotArr;
            this.b = countDownLatch;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            this.f167a[0] = null;
            this.b.countDown();
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            this.f167a[0] = dataSnapshot;
            this.b.countDown();
        }
    }

    public static boolean a(DataSnapshot... dataSnapshotArr) {
        for (DataSnapshot dataSnapshot : dataSnapshotArr) {
            if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                return false;
            }
        }
        return true;
    }

    public static DataSnapshot b(DatabaseReference databaseReference) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        DataSnapshot[] dataSnapshotArr = new DataSnapshot[1];
        databaseReference.addListenerForSingleValueEvent(new a(dataSnapshotArr, countDownLatch));
        try {
            countDownLatch.await(300, TimeUnit.SECONDS);
            return dataSnapshotArr[0];
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject c(Context context, xj1 xj1, String str) {
        String str2;
        String str3;
        int i;
        CityDataRepository cityDataRepository = new CityDataRepository(context);
        b = cityDataRepository;
        List<CityData> data = cityDataRepository.getData(str);
        CountDownLatch countDownLatch = null;
        if (data == null || data.size() <= 0) {
            str3 = null;
            str2 = null;
            i = 0;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                for (CityData cityData : data) {
                    String mode = cityData.getMode();
                    if (!jSONObject.has(mode)) {
                        jSONObject.put(mode, new JSONObject());
                    }
                    jSONObject.getJSONObject(mode).put(cityData.getDataId(), new JSONObject(cityData.getData()));
                }
            } catch (Exception e) {
                HashMap m0 = hj1.m0("error name", e.toString());
                m0.put("attribution type", data.get(0).getType());
                m0.put("transit mode", "");
                m0.put("etag", data.get(0).getEtag());
                m0.put("version", Integer.valueOf(data.get(0).getVersion()));
                b00 b00 = b00.f358a;
                b00.a().b(e);
                jSONObject = new JSONObject();
            }
            str3 = jSONObject.toString();
            str2 = data.get(0).getEtag();
            i = data.get(0).getVersion();
        }
        JSONObject[] jSONObjectArr = {null};
        if (str3 != null) {
            try {
                jSONObjectArr[0] = new JSONObject(str3);
            } catch (JSONException e2) {
                b00 b002 = b00.f358a;
                hj1.X0(e2, b00.a());
            }
        } else {
            countDownLatch = new CountDownLatch(1);
        }
        Uri.Builder builder = new Uri.Builder();
        e80 k = xt.f3961a.k();
        ed1 l = hj1.l("firebase config call initiated", Long.MIN_VALUE, "attribution type", str);
        l.a("network type", vn.Y(context));
        l.a("version", Integer.valueOf(i));
        jz5.b().g(l);
        builder.encodedPath(ut.I).appendPath(k.d().getName().toLowerCase()).appendPath("types").appendPath(str);
        b70 b70 = new b70(builder.build().toString(), null, new zh1(jSONObjectArr, i, str, str3, new String[]{str2}, countDownLatch), new yh1(str3, jSONObjectArr, countDownLatch), str2 != null ? hj1.m0("If-None-Match", str2) : null);
        b70.n = false;
        b70.q = new nj1(180000, 5, 1.0f);
        xj1.a(b70);
        if (countDownLatch != null) {
            try {
                countDownLatch.await(300, TimeUnit.SECONDS);
            } catch (InterruptedException e3) {
                d("latch exception");
                e3.printStackTrace();
            }
        }
        return jSONObjectArr[0];
    }

    public static void d(String str) {
        jz5.b().g(hj1.l("firebase config call reset version", Long.MIN_VALUE, "source", str));
        b.removeCityData();
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x014d A[SYNTHETIC, Splitter:B:41:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e() {
        /*
        // Method dump skipped, instructions count: 350
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ai1.e():void");
    }
}
