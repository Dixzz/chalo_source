package defpackage;

import app.zophop.models.StreamInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.models.Point;

/* renamed from: ww0  reason: default package */
/* compiled from: TripFragment */
public class ww0 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ tw0 f3846a;

    public ww0(tw0 tw0) {
        this.f3846a = tw0;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        String str = this.f3846a.v;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        tw0 tw0 = this.f3846a;
        if (tw0.l != null) {
            boolean z = tw0.p == null;
            Objects.requireNonNull(tw0);
            ArrayList arrayList = new ArrayList();
            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                try {
                    Integer valueOf = Integer.valueOf(new JSONObject(dataSnapshot2.getValue().toString()).getInt("_eta"));
                    Long valueOf2 = Long.valueOf(new JSONObject(dataSnapshot2.getValue().toString()).getLong("_time"));
                    String string = new JSONObject(dataSnapshot2.getValue().toString()).getString("_stopId");
                    boolean optBoolean = new JSONObject(dataSnapshot2.getValue().toString()).optBoolean("_isHalted");
                    if (!vn.R0(valueOf2.longValue(), valueOf.intValue(), false)) {
                        StreamInfo streamInfo = new StreamInfo(dataSnapshot2.getKey(), valueOf.intValue(), string, (Point) new Gson().fromJson(dataSnapshot2.getValue().toString(), Point.class), valueOf2.longValue());
                        streamInfo.setHaltedStatus(optBoolean);
                        arrayList.add(streamInfo);
                    }
                } catch (JSONException e) {
                    e.getLocalizedMessage();
                }
            }
            this.f3846a.l.f(arrayList, z);
            this.f3846a.l.notifyDataSetChanged();
            if (arrayList.size() > 0) {
                tw0 tw02 = this.f3846a;
                Objects.requireNonNull(tw02);
                if (arrayList.size() > 0) {
                    long j = 0;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        long timeStamp = ((StreamInfo) it.next()).getTimeStamp();
                        if (timeStamp > j) {
                            j = timeStamp;
                        }
                    }
                    if (j > tw02.y) {
                        tw02.y = j;
                    }
                }
                tw0 tw03 = this.f3846a;
                arrayList.size();
                tw03.c();
            }
        }
    }
}
