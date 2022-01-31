package defpackage;

import android.os.Bundle;

/* renamed from: h5  reason: default package */
/* compiled from: NotificationCompat */
public abstract class h5 {

    /* renamed from: a  reason: collision with root package name */
    public f5 f1340a;
    public CharSequence b;
    public CharSequence c;
    public boolean d = false;

    public void a(Bundle bundle) {
        if (this.d) {
            bundle.putCharSequence("android.summaryText", this.c);
        }
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String c2 = c();
        if (c2 != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
        }
    }

    public abstract void b(b5 b5Var);

    public abstract String c();
}
