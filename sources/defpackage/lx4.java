package defpackage;

import android.content.Context;
import android.content.Intent;

/* renamed from: lx4  reason: default package */
public final class lx4 {
    public static final nv4 c = new nv4("ReviewService");

    /* renamed from: a  reason: collision with root package name */
    public final xv4<kv4> f2291a;
    public final String b;

    public lx4(Context context) {
        this.b = context.getPackageName();
        this.f2291a = new xv4<>(context, c, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), ix4.f1582a);
    }
}
