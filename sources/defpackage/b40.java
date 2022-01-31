package defpackage;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: b40  reason: default package */
/* compiled from: RealTimeFeature */
public class b40 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ji1 f375a;

    public b40(z30 z30, ji1 ji1) {
        this.f375a = ji1;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        this.f375a.a(databaseError.getDetails());
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        j10 e = ii1.e(dataSnapshot);
        if (e.b().size() != 0) {
            this.f375a.onSuccess(e);
        } else if (e.a() == Integer.MAX_VALUE) {
            this.f375a.a("no_etas");
        } else if (e.a() >= 7200) {
            this.f375a.a("all_max_etas");
        } else {
            this.f375a.onSuccess(e);
        }
    }
}
