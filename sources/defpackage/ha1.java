package defpackage;

import android.app.Application;
import android.content.Context;

/* renamed from: ha1  reason: default package */
/* compiled from: UniversalPassViewModel.kt */
public final class ha1 extends lg {
    public final Context d;
    public boolean e = true;
    public boolean f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ha1(Application application) {
        super(application);
        n86.e(application, "application");
        this.d = application.getApplicationContext();
    }
}
