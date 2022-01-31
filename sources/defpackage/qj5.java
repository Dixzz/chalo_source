package defpackage;

import android.os.Looper;
import app.zophop.models.mTicketing.ProductPromotionsObject;

/* renamed from: qj5  reason: default package */
/* compiled from: AirshipLoopers */
public class qj5 {

    /* renamed from: a  reason: collision with root package name */
    public static Looper f2947a;

    public static Looper a() {
        if (f2947a == null) {
            synchronized (qj5.class) {
                if (f2947a == null) {
                    ey5 ey5 = new ey5(ProductPromotionsObject.KEY_BACKGROUND);
                    ey5.start();
                    f2947a = ey5.getLooper();
                }
            }
        }
        return f2947a;
    }
}
