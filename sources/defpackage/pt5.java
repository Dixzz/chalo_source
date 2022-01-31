package defpackage;

import java.util.Objects;

/* renamed from: pt5  reason: default package */
/* compiled from: NativeBridge */
public class pt5 implements pk5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2848a;
    public final /* synthetic */ gz5 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ot5 d;

    public pt5(ot5 ot5, String str, gz5 gz5, String str2) {
        this.d = ot5;
        this.f2848a = str;
        this.b = gz5;
        this.c = str2;
    }

    @Override // defpackage.pk5
    public void a(ok5 ok5, rk5 rk5) {
        String str;
        int i = rk5.c;
        if (i == 2) {
            str = String.format("Action %s rejected its arguments", this.f2848a);
        } else if (i == 3) {
            str = String.format("Action %s not found", this.f2848a);
        } else if (i != 4) {
            str = null;
        } else {
            Exception exc = rk5.f3092a;
            if (exc != null) {
                str = exc.getMessage();
            } else {
                str = String.format("Action %s failed with unspecified error", this.f2848a);
            }
        }
        this.d.d(this.b, str, rk5.b, this.c);
        synchronized (this) {
            Objects.requireNonNull(this.d);
        }
    }
}
