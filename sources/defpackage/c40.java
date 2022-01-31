package defpackage;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: c40  reason: default package */
/* compiled from: RealTimeFeature */
public class c40 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ji1 f515a;

    public c40(z30 z30, ji1 ji1) {
        this.f515a = ji1;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        this.f515a.a(databaseError.getDetails());
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        j10 e = ii1.e(dataSnapshot);
        if (e.b().size() != 0) {
            this.f515a.onSuccess(e);
        } else if (e.a() == Integer.MAX_VALUE) {
            this.f515a.a("no_etas");
        } else if (e.a() >= 7200) {
            this.f515a.a("all_max_etas");
        } else {
            this.f515a.onSuccess(e);
        }
    }
}
