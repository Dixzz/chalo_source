package defpackage;

import defpackage.m36;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: g46  reason: default package */
/* compiled from: Socket */
public class g46 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i46[] f1214a;
    public final /* synthetic */ m36.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ u36 d;

    public g46(u36 u36, i46[] i46Arr, m36.a aVar, String str, u36 u362) {
        this.f1214a = i46Arr;
        this.b = aVar;
        this.c = str;
        this.d = u362;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        n36 n36;
        Object obj = objArr[0];
        if (obj instanceof Exception) {
            n36 = new n36("probe error", (Exception) obj);
        } else if (obj instanceof String) {
            StringBuilder i0 = hj1.i0("probe error: ");
            i0.append((String) obj);
            n36 = new n36(i0.toString());
        } else {
            n36 = new n36("probe error");
        }
        String str = this.f1214a[0].c;
        this.b.a(new Object[0]);
        Logger logger = u36.B;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("probe transport \"%s\" failed because of error: %s", this.c, obj));
        }
        this.d.a("upgradeError", n36);
    }
}
