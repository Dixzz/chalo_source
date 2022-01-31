package defpackage;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import defpackage.u95;

/* renamed from: da5  reason: default package */
/* compiled from: RotationListener */
public class da5 extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ea5 f815a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public da5(ea5 ea5, Context context, int i) {
        super(context, i);
        this.f815a = ea5;
    }

    public void onOrientationChanged(int i) {
        ea5 ea5 = this.f815a;
        WindowManager windowManager = ea5.b;
        ca5 ca5 = ea5.d;
        if (windowManager != null && ca5 != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            ea5 ea52 = this.f815a;
            if (rotation != ea52.f950a) {
                ea52.f950a = rotation;
                u95.c cVar = (u95.c) ca5;
                u95.this.h.postDelayed(new v95(cVar), 250);
            }
        }
    }
}
