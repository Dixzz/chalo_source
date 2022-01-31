package defpackage;

import android.view.View;
import android.view.WindowId;

/* renamed from: fo  reason: default package */
/* compiled from: WindowIdApi18 */
public class fo implements go {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f1149a;

    public fo(View view) {
        this.f1149a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof fo) && ((fo) obj).f1149a.equals(this.f1149a);
    }

    public int hashCode() {
        return this.f1149a.hashCode();
    }
}
