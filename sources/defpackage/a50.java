package defpackage;

import android.content.Context;
import app.zophop.models.Trip;
import defpackage.n00;

/* renamed from: a50  reason: default package */
/* compiled from: ScheduleFeature */
public class a50 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f117a;
    public final /* synthetic */ String b;
    public final /* synthetic */ w40 c;

    public a50(w40 w40, long j, String str) {
        this.c = w40;
        this.f117a = j;
        this.b = str;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        Context context = this.c.c;
        dk1.toString();
        dk1.toString();
        jz5.b().i(new Trip(this.b, null, null, null));
    }
}
