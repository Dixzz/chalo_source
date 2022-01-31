package defpackage;

import com.google.firebase.database.DataSnapshot;

/* renamed from: l30  reason: default package */
/* compiled from: NearbyStopTripRequestHandler */
public class l30 implements Runnable {
    public final /* synthetic */ m30 f;

    public l30(m30 m30) {
        this.f = m30;
    }

    public void run() {
        m30 m30 = this.f;
        if (m30.k != null && !m30.m && m30.a()) {
            Iterable<DataSnapshot> children = m30.k.getChildren();
            m30.d.clear();
            for (DataSnapshot dataSnapshot : children) {
                j10 e = ii1.e(dataSnapshot);
                if (e.a() < 7200) {
                    m30.d.put(dataSnapshot.getKey(), e.c().get(0));
                } else if (e.b().size() != 0) {
                    m30.d.put(dataSnapshot.getKey(), e.b().get(0));
                }
            }
            m30.c();
        }
        m30 m302 = this.f;
        m302.h.postDelayed(m302.j, 500);
    }
}
