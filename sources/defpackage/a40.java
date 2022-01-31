package defpackage;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: a40  reason: default package */
/* compiled from: RealTimeFeature */
public class a40 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ji1 f108a;

    public a40(z30 z30, ji1 ji1) {
        this.f108a = ji1;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        this.f108a.a("real_time_unavailable");
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        this.f108a.onSuccess(Integer.valueOf((int) dataSnapshot.getChildrenCount()));
    }
}
