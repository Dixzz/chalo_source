package defpackage;

import com.razorpay.AnalyticsConstants;

/* renamed from: xh6  reason: default package */
/* compiled from: EventListener.kt */
public abstract class xh6 {

    /* renamed from: a  reason: collision with root package name */
    public static final xh6 f3929a = new a();

    /* renamed from: xh6$a */
    /* compiled from: EventListener.kt */
    public static final class a extends xh6 {
    }

    /* renamed from: xh6$b */
    /* compiled from: EventListener.kt */
    public interface b {
        xh6 a(ih6 ih6);
    }

    public void a(ih6 ih6, oh6 oh6) {
        n86.f(ih6, AnalyticsConstants.CALL);
        n86.f(oh6, "connection");
    }
}
