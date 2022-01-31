package defpackage;

import android.content.Context;
import defpackage.n00;

/* renamed from: r50  reason: default package */
/* compiled from: UniversalSearchFeature */
public class r50 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f3044a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ q50 d;

    public r50(q50 q50, long j, String str, String str2) {
        this.d = q50;
        this.f3044a = j;
        this.b = str;
        this.c = str2;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        Context context = this.d.f2897a;
        dk1.toString();
        vn.e("universal search failure volley", vn.K0(this.d.f2897a));
        dk1.printStackTrace();
        dk1.getMessage();
        q50.a(this.d, this.b, this.f3044a, dk1.getMessage(), this.c);
    }
}
