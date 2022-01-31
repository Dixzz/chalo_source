package defpackage;

import defpackage.m66;
import java.util.concurrent.CancellationException;

/* renamed from: rc6  reason: default package */
/* compiled from: Job.kt */
public interface rc6 extends m66.a {
    public static final /* synthetic */ int e = 0;

    /* renamed from: rc6$a */
    /* compiled from: Job.kt */
    public static final class a implements m66.b<rc6> {
        public static final /* synthetic */ a f = new a();
    }

    boolean a();

    void c(CancellationException cancellationException);

    yb6 i(boolean z, boolean z2, s76<? super Throwable, s56> s76);

    CancellationException j();

    yb6 o(s76<? super Throwable, s56> s76);

    boolean start();

    wa6 x(ya6 ya6);
}
