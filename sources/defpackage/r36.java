package defpackage;

import defpackage.m36;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: r36  reason: default package */
/* compiled from: Socket */
public class r36 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i46[] f3035a;
    public final /* synthetic */ m36.a b;

    public r36(u36 u36, i46[] i46Arr, m36.a aVar) {
        this.f3035a = i46Arr;
        this.b = aVar;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        i46 i46 = (i46) objArr[0];
        i46[] i46Arr = this.f3035a;
        if (i46Arr[0] != null && !i46.c.equals(i46Arr[0].c)) {
            Logger logger = u36.B;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("'%s' works - aborting '%s'", i46.c, this.f3035a[0].c));
            }
            this.b.a(new Object[0]);
        }
    }
}
